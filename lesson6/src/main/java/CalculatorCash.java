import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class CalculatorCash {
    private HashMap<Integer, Integer> cash = new HashMap<Integer, Integer>();

    public void putCash(Integer param, Integer result) {
        cash.put(param, result);
    }



    public static void main(String[] args) {
        InvocationHandler handler = new MyProxy();
        Class[] classes = new Class[]{Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null, classes, handler);

    }


    static class MyProxy implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            return null;
        }
    }
}
