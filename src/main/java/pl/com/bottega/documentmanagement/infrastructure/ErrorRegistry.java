package pl.com.bottega.documentmanagement.infrastructure;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by arkadiuszarak on 20/08/2016.
 */
public class ErrorRegistry {

    private static ErrorRegistry singleton;

    private List<String> errors = new LinkedList<>();

    private ErrorRegistry(){}

    public synchronized static ErrorRegistry getInstance(){
        if (singleton == null)
            synchronized (ErrorRegistry.class){
                if (singleton == null)
                    singleton = new ErrorRegistry();
            }
        return singleton;
    }

    public void registerError(String error){
        errors.add(error);
    }
}
