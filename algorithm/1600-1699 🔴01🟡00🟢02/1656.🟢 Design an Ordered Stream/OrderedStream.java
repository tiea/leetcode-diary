import java.util.List;
import java.util.ArrayList;

class OrderedStream {
    String[] arr;
    int ptr, length;

    public OrderedStream(int n) {
        arr = new String[n];
        length = n;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        arr[idKey - 1] = value;
        String ptrValue = arr[ptr];
        if (ptrValue == null) {
            return result;
        }
        do {
            result.add(ptrValue);
        } while (ptr + 1 < length && (ptrValue = arr[++ptr]) != null);
        return result;
    }

}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */