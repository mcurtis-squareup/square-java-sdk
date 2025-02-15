
package com.squareup.square;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.request.MultipartFileWrapper;
import com.squareup.square.http.request.MultipartWrapper;
import com.squareup.square.utilities.JsonObject;
import com.squareup.square.utilities.JsonValue;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This is a Helper class with commonly used utilities for the SDK.
 */
public class ApiHelper {

    // Deserialization of Json data
    public static ObjectMapper mapper = new ObjectMapper() {
        private static final long serialVersionUID = -174113593500315394L;
        {
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            configOverride(BigDecimal.class).setFormat(
                    JsonFormat.Value.forShape(JsonFormat.Shape.STRING));
        }
    };

    /**
     * List of classes that are wrapped directly. This information is needed when
     * traversing object trees for reference matching.
     */
    private static final Set<Object> WRAPPER_TYPES = new HashSet<Object>(Arrays.asList(
            Boolean.class, Character.class, Byte.class, Short.class, String.class,
            Integer.class, Long.class, Float.class, Double.class, BigDecimal.class,
            Void.class, File.class, MultipartWrapper.class, MultipartFileWrapper.class));

    /**
     * Get a JsonSerializer instance from the provided annotation.
     * @param serializerAnnotation The Annotation containing information about the serializer.
     * @return The JsonSerializer instance of the required type.
     */
    @SuppressWarnings("rawtypes")
    private static JsonSerializer getSerializer(JsonSerialize serializerAnnotation) {
        try {
            return serializerAnnotation.using().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json Serialization of a given object.
     * @param  obj The object to serialize into Json.
     * @return The serialized Json String representation of the given object.
     * @throws JsonProcessingException Signals that a Json Processing Exception has occurred.
     */
    public static String serialize(Object obj)
            throws JsonProcessingException {
        if (obj == null) {
            return null;
        }

        return mapper.writeValueAsString(obj);
    }

    /**
     * Json Serialization of a given object using a specified JsonSerializer.
     * @param  obj The object to serialize into Json.
     * @param  serializer The instance of JsonSerializer to use.
     * @return The serialized Json string representation of the given object.
     * @throws JsonProcessingException Signals that a Json Processing Exception has occurred.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String serialize(Object obj, final JsonSerializer serializer)
            throws JsonProcessingException {
        if (obj == null || serializer == null) {
            return null;
        }
        
        if (obj.getClass().getName().equals("java.util.ArrayList")) {
            // need to find the generic type if it's an ArrayList
            final Class<? extends Object> cls = ((ArrayList) obj).get(0).getClass();

            return new ObjectMapper() {
                private static final long serialVersionUID = -1639089569991988232L;
                {
                    SimpleModule module = new SimpleModule();
                    module.addSerializer(cls, serializer);
                    this.registerModule(module);
                }
            }.writeValueAsString(obj);
        }

        final Class<? extends Object> cls = obj.getClass();
        return new ObjectMapper() {
            private static final long serialVersionUID = -1639089569991988232L;
            {
                SimpleModule module = new SimpleModule();
                module.addSerializer(cls, serializer);
                this.registerModule(module);
            }
        }.writeValueAsString(obj);
    }

    /**
     * Json deserialization of the given Json string.
     * @param   <T> The type of the object to deserialize into
     * @param   json The Json string to deserialize
     * @param   clazz The type of the object to deserialize into
     * @return  The deserialized object
     * @throws  IOException Signals if any I/O exception occured.
     */
    public static <T extends Object> T deserialize(String json, Class<T> clazz)
            throws IOException {
        if (isNullOrWhiteSpace(json)) {
            return null;
        }

        return mapper.readValue(json, clazz);
    }

    /**
     * Json deserialization of the given Json string.
     * @param   json The Json string to deserialize
     * @return  The deserialized Json as a Map
     * @throws  IOException Signals if any I/O exception occured.
     */
    public static LinkedHashMap<String, Object> deserialize(String json)
            throws IOException {
        if (isNullOrWhiteSpace(json)) {
            return null;
        }

        TypeReference<LinkedHashMap<String, Object>> typeRef 
            = new TypeReference<LinkedHashMap<String, Object>>(){};
        return deserialize(json, typeRef);
    }

    /**
     * JSON Deserialization of the given json string.
     * @param   json The json string to deserialize
     * @param   typeReference TypeReference of T
     * @param   <T>  The type of the object to deserialize into
     * @return  The deserialized object
     * @throws  IOException Signals if any I/O exception occured.
     */
    public static <T extends Object> T deserialize(String json, TypeReference<T> typeReference)
            throws IOException {
        if (isNullOrWhiteSpace(json)) {
            return null;
        }

        return mapper.readValue(json, typeReference);
    }

    /**
     * Json deserialization of the given Json string.
     * @param   json The Json string to deserialize
     * @return  The deserialized Json as an Object
     */
    public static Object deserializeAsObject(String json) {
        if (isNullOrWhiteSpace(json)) {
            return null;
        }
        try {
            return ApiHelper.deserialize(json, new TypeReference<Object>() {});
        } catch (IOException e) {
            // Failed to deserialize when json is not representing a JSON object.
            // i.e. either its string or any primitive type.
            return json;
        }
    }

    /**
     * JSON Deserialization of the given json string.
     * @param   <T> The type of the object to deserialize into
     * @param   json The Json string to deserialize
     * @param   classArray The class of the array of objects to deserialize into
     * @return  The deserialized list of objects
     * @throws  IOException Signals if any I/O exception occured.
     */
    public static <T extends Object> List<T> deserializeArray(String json, Class<T[]> classArray)
            throws IOException {
        if (isNullOrWhiteSpace(json)) {
            return null;
        }
        
        return Arrays.asList(mapper.readValue(json, classArray));
    }

    /**
     * Populates an object of an ApiException subclass with the required properties.
     * @param   json The Json string to deserialize
     * @param   obj The object to populate.
     * @throws  IOException Signals if any I/O exception occured.
     */
    public static void populate(String json, ApiException obj)
            throws IOException {
        if (!isNullOrWhiteSpace(json)) {
            mapper.readerForUpdating(obj).readValue(json);
        }
    }

    /**
     * Replaces template parameters in the given URL.
     * @param   queryBuilder The query string builder to replace the template parameters
     * @param   parameters The parameters to replace in the URL
     */
    public static void appendUrlWithTemplateParameters(StringBuilder queryBuilder, 
        Map<String, SimpleEntry<Object, Boolean>> parameters) {
        // Perform parameter validation
        if (null == queryBuilder) {
            throw new IllegalArgumentException(
                    "Given value for parameter \"queryBuilder\" is invalid.");
        }

        if (null == parameters) {
            return;
        }

        // Iterate and append parameters
        for (Map.Entry<String, SimpleEntry<Object, Boolean>> pair : parameters.entrySet()) {
        
            String replaceValue = "";
            Object element = pair.getValue().getKey();
            boolean shouldEncode = pair.getValue().getValue();
            
            // Load element value as string
            if (null == element) {
                replaceValue = "";
            } else if (element instanceof Collection<?>) {
                replaceValue = flattenCollection("", (Collection<?>) element, shouldEncode,
                        "%s%s%s", '/');
            } else {
                if (shouldEncode) {
                    replaceValue = tryUrlEncode(element.toString(), false);
                } else {
                    replaceValue = element.toString();
                }
            }

            // Find the template parameter and replace it with its value
            replaceAll(queryBuilder, "{" + pair.getKey() + "}", replaceValue);
        }
    }

    /**
     * Appends the given set of parameters to the given query string.
     * @param   queryBuilder The query URL string to append the parameters.
     * @param   parameters The parameters to append.
     */
    public static void appendUrlWithQueryParameters(StringBuilder queryBuilder,
            Map<String, Object> parameters) {
        // Perform parameter validation
        if (queryBuilder == null) {
            throw new IllegalArgumentException(
                    "Given value for parameter \"queryBuilder\" is invalid.");
        }
        if (parameters == null || parameters.isEmpty()) {
            return;
        }
        
        // Check if query string already has parameters
        boolean hasParams = queryBuilder.indexOf("?") > 0;
        queryBuilder.append(hasParams ? '&' : '?');

        encodeObjectAsQueryString("", parameters, queryBuilder);
    }

    /**
     * Validates if the string is null, empty or whitespace.
     * @param   s The string to validate.
     * @return  The result of validation.
     */
    public static boolean isNullOrWhiteSpace(String s) {
        if (s == null) {
            return true;
        }

        int length = s.length();
        if (length > 0) {
            for (int start = 0, middle = length / 2, end = length - 1; start <= middle;
                    start++, end--) {
                if (s.charAt(start) > ' ' || s.charAt(end) > ' ') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Replaces all occurrences of the given string in the string builder.
     * @param   stringBuilder The string builder to update with replaced strings.
     * @param   toReplace The string to replace in the string builder.
     * @param   replaceWith The string to replace with.
     */
    public static void replaceAll(StringBuilder stringBuilder, String toReplace,
            String replaceWith) {
        int index = stringBuilder.indexOf(toReplace);
        
        while (index != -1) {
            stringBuilder.replace(index, index + toReplace.length(), replaceWith);
            index += replaceWith.length(); // Move to the end of the replacement
            index = stringBuilder.indexOf(toReplace, index);
        }
    }

    /**
     * Removes null values from the given map.
     * @param map Map of values.
     */
    public static void removeNullValues(Map<String, ?> map) {
        if (map == null) {
            return;
        }

        map.values().removeAll(Collections.singleton(null));
    }

    /**
     * Validates and processes the given URL.
     * @param    url The given URL to process.
     * @return   Pre-process URL as string.
     */
    public static String cleanUrl(StringBuilder url) {
        // Ensures that the URLs are absolute
        Pattern pattern = Pattern.compile("^(https?://[^/]+)");
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Url format.");
        }

        // Get the http protocol match
        String protocol = matcher.group(1);

        // Removes redundant forward slashes
        String query = url.substring(protocol.length());
        query = query.replaceAll("//+", "/");

        // Returns processed URL
        return protocol.concat(query);
    }

    /**
     * Prepares Array style form fields from a given array of values.
     * @param   value Value for the form fields.
     * @return  Dictionary of form fields created from array elements.
     */
    public static List<SimpleEntry<String, Object>> prepareFormFields(Map<?, ?> value) {
        List<SimpleEntry<String, Object>> formFields = new ArrayList<>();
        if (value != null) {
            objectToList("", value, formFields, new HashSet<Integer>());
        }
        return formFields;
    }

    /**
     * Encodes a given object to URL encoded string.
     * @param name Name of the object.
     * @param obj Raw object sent from caller.
     * @param objBuilder String of elements.
     */
    private static void encodeObjectAsQueryString(String name, Object obj,
            StringBuilder objBuilder) {
        if (obj == null) {
            return;
        }

        List<SimpleEntry<String, Object>> objectList = new ArrayList<>();
        objectToList(name, obj, objectList, new HashSet<Integer>());
        boolean hasParam = false;


        for (SimpleEntry<String, Object> pair : objectList) {
            String paramKeyValPair;
            String accessor = pair.getKey();
            // Ignore null
            Object value = pair.getValue();
            if (value == null) {
                continue;
            }
                
            hasParam = true;
            // Load element value as string
            paramKeyValPair = 
                    String.format("%s=%s&", accessor, tryUrlEncode(value.toString(), false));
            objBuilder.append(paramKeyValPair);

        }

        // Removing the last &
        if (hasParam) {
            objBuilder.setLength(objBuilder.length() - 1);
        }
    }

    /**
     * Flattening a collection of objects into a string.
     * @param   array Array of elements to flatten.
     * @param   fmt Format string to use for array flattening.
     * @param   separator Separator to use for string concatenation.
     * @return  Representative string made up of array elements.
     */
    private static String flattenCollection(String elemName, Collection<?> array, boolean encode,
            String fmt, char separator) {
        StringBuilder builder = new StringBuilder();

        // Append all elements of the array into a string
        for (Object element : array) {
            String elemValue = null;

            // Replace null values with empty string to maintain index order
            if (element == null) {
                elemValue = "";
            } else {
                elemValue = element.toString();
            }
            if (encode) {
                elemValue = tryUrlEncode(elemValue, false);
            }
            builder.append(String.format(fmt, elemName, elemValue, separator));
        }

        // Remove the last separator, if appended
        if ((builder.length() > 1) && (builder.charAt(builder.length() - 1) == separator)) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    /**
     * Tries URL encode using UTF-8.
     * @param value The value to URL encode.
     * @param spaceAsPercentEncoded The flag get space character as percent encoded.
     * @return Encoded url.
     */
    public static String tryUrlEncode(String value, boolean spaceAsPercentEncoded) {
        try {
            String encodedUrl = URLEncoder.encode(value, "UTF-8");
            if (spaceAsPercentEncoded) {
                return encodedUrl.replace("+", "%20");
            }
            return encodedUrl;
        } catch (UnsupportedEncodingException ex) {
            return value;
        }
    }

    private static void objectToList(String objName, Collection<?> obj,
            List<SimpleEntry<String, Object>> objectList, HashSet<Integer> processed) {

        Collection<?> array = obj;
        array = sortByWrapperType(array);
        // Append all elements of the array into a string
        int index = 0;
        for (Object element : array) {
            //load key value pair
            String key = String.format("%s[%d]", objName, index++);
            loadKeyValuePairForEncoding(key, element, objectList, processed);
        }
      
    }

    private static void objectToList(String objName, Map<?, ?> obj, 
            List<SimpleEntry<String, Object>> objectList, 
            HashSet<Integer> processed) {
        // Process map
        Map<?, ?> map = obj;
        // Append all elements of the array into a string
        for (Map.Entry<?, ?> pair : map.entrySet()) {
            String attribName = pair.getKey().toString();
            if ((objName != null) && (!objName.isEmpty())) {
                attribName = String.format("%s[%s]", objName, attribName);
            }
            loadKeyValuePairForEncoding(attribName, pair.getValue(), objectList, processed);
        }
    }

    /**
     * Converts a given object to a form encoded map.
     * @param objName Name of the object.
     * @param obj The object to convert into a map.
     * @param objectList The object list to populate.
     * @param processed List of object hashCodes that are already parsed.
     */
    private static void objectToList(String objName, Object obj,
            List<SimpleEntry<String, Object>> objectList, HashSet<Integer> processed) {
        // Null values need not to be processed
        if (obj == null) {
            return;
        }

        // Wrapper types are autoboxed, so reference checking is not needed
        Class<?> clazz = obj.getClass();
        if (!isWrapperType(clazz)) {
            // Avoid infinite recursion
            if (processed.contains(objName.hashCode())) {
                return;
            }
            processed.add(objName.hashCode());
        }

        // Process arrays
        if (obj instanceof Collection<?>) {
            objectToList(objName, (Collection<?>) obj, objectList,  processed);
        } else if (obj.getClass().isArray()) {
            // Process array

            Object[] array = (Object[]) obj;
            // Append all elements in the array into a string
            int index = 0;
            for (Object element : array) {
                // Load key value pair
                String key = String.format("%s[%d]", objName, index++);
                loadKeyValuePairForEncoding(key, element, objectList, processed);
            }
        } else if (obj instanceof Map) {
            objectToList(objName, (Map<?, ?>) obj, objectList,  processed);
        } else {
            // Process objects
            // Invoke getter methods
            while (clazz != null) {
                for (Method method : clazz.getDeclaredMethods()) {

                    // Is a public/protected getter or internalGetter?
                    if (method.getParameterTypes().length != 0
                            || Modifier.isPrivate(method.getModifiers())
                            || (!method.getName().startsWith("get")
                                    && !method.getName().startsWith("internalGet"))) {
                        continue;
                    }

                    // Get JsonGetter annotation
                    Annotation getterAnnotation = method.getAnnotation(JsonGetter.class);
                    if (getterAnnotation == null) {
                        continue;
                    }

                    // Load key name from getter attribute name
                    String attribName = ((JsonGetter) getterAnnotation).value();
                    if ((objName != null) && (!objName.isEmpty())) {
                        attribName = String.format("%s[%s]", objName, attribName);
                    }

                    try {
                        // Load value by invoking getter method
                        method.setAccessible(true);
                        Object value = method.invoke(obj);
                        JsonSerialize serializerAnnotation = method
                                .getAnnotation(JsonSerialize.class);
                        // Load key value pair into objectList
                        if (serializerAnnotation != null) {
                            loadKeyValuePairForEncoding(attribName, value, objectList, processed,
                                    serializerAnnotation);
                        } else {
                            loadKeyValuePairForEncoding(attribName, value, objectList, processed);
                        }
                    } catch (IllegalAccessException | IllegalArgumentException
                            | InvocationTargetException e) {
                        // This block only calls getter methods.
                        // These getters don't throw any exception except invocationTargetException.
                        // The getters are public so there is no chance of an IllegalAccessException
                        // Steps we've followed ensure that the object has the specified method.
                    }
                }
                clazz = clazz.getSuperclass();
            }
        }
    }

    /**
     * Pushes all wrapper types to the last in given list.
     * @param array The list on which the sorting is performed.
     * @return The sorted list.
     */
    private static Collection<?> sortByWrapperType(Collection<?> array) {
        return array.stream().sorted(Comparator.comparing(element -> {
            if (isWrapperType(element)) {
                return 1;
            }
            return -1;
        })).collect(Collectors.toList());
    }

    /**
     * While processing objects to map, decides whether to perform recursion or load value.
     * @param key The key for creating key value pair.
     * @param value The value to process against the given key.
     * @param objectList The object list to process with key value pair.
     * @param processed List of processed objects hashCodes.
     */
    private static void loadKeyValuePairForEncoding(String key, Object value,
            List<SimpleEntry<String, Object>> objectList, HashSet<Integer> processed) {
        if (value == null) {
            return;
        }
        if (isWrapperType(value)) {
            objectList.add(new SimpleEntry<String, Object>(key, value));
        } else if (value.getClass().equals(JsonObject.class)) {
            objectToList(key, ((JsonObject) value).getStoredObject(), objectList, processed);
        } else if (value.getClass().equals(JsonValue.class)) {
            Object storedValue = ((JsonValue) value).getStoredObject();
            if (isWrapperType(storedValue)) {
                objectList.add(new SimpleEntry<String, Object>(key, storedValue));
            } else {
                objectToList(key, storedValue, objectList, processed);
            }
        } else if (value instanceof UUID) {
            // UUIDs can be converted to string
            objectList.add(new SimpleEntry<String, Object>(key, value.toString()));
        } else {
            objectToList(key, value, objectList, processed);
        }
    }

    /**
     * While processing objects to map, loads value after serializing.
     * @param key The key to used for creation of key value pair.
     * @param value The value to process against the given key.
     * @param objectList The object list to process with key value pair.
     * @param processed List of processed objects hashCodes.
     * @param serializerAnnotation Annotation for serializer
     */
    @SuppressWarnings("unused")
    private static void loadKeyValuePairForEncoding(String key, Object value,
            List<SimpleEntry<String, Object>> objectList, HashSet<Integer> processed,
            JsonSerialize serializerAnnotation) {
        if (value == null) {
            return;
        }

        try {
            value = serialize(value, getSerializer(serializerAnnotation));
            if (value.toString().startsWith("\"")) {
                value = value.toString().substring(1, value.toString().length() - 1);
            }
            objectList.add(new SimpleEntry<String, Object>(key, value));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if the given object can be wrapped directly.
     * @param object The given object.
     * @return true if the class is an autoboxed class e.g., Integer.
     */
    private static boolean isWrapperType(Object object) {
        return WRAPPER_TYPES.contains(object.getClass()) 
                || object.getClass().isPrimitive() || object.getClass().isEnum();
    }
}