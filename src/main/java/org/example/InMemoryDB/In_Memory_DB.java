package org.example.InMemoryDB;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class In_Memory_DB {

    private Map<String,String> store=new HashMap<>();
    private Deque<Map<String,String>>transactionStack=new ArrayDeque<>();

    private final String DELETED_MARKER="<DELETED>";

    // core db operations

    public void set(String key, String value) {

        if(transactionStack.isEmpty()){
            store.put(key,value);
        }else{
            transactionStack.peek().put(key,value);
        }
    }

    public String get(String key){

        for(Map<String,String> tsk:transactionStack){

            if(tsk.containsKey(key)){
                String value=tsk.get(key);
                if(DELETED_MARKER.equals(value)) return null;
                return tsk.get(key);
            }
        }
        return store.get(key);
    }

    public void unset(String key){
        if(transactionStack.isEmpty()){
            store.remove(key);
        }else{
            transactionStack.peek().put(key,DELETED_MARKER);
        }
    }
    //Transaction control

    public void begin(){
        transactionStack.add(new HashMap<>());
    }

    public void rollBack(){

        if(transactionStack.isEmpty()){
            throw new IllegalStateException("Transaction stack is Empty");
        }
        transactionStack.pop();
    }

    public void commit(){

        if(transactionStack.isEmpty()){
            throw new IllegalStateException("Transaction stack is Empty");
        }
        Map<String,String>currentTsx=transactionStack.pop();

        if(!transactionStack.isEmpty()){
            Map<String ,String>parent=transactionStack.peek();
            for(Map.Entry<String,String>entry: currentTsx.entrySet()){
                parent.put(entry.getKey(), entry.getValue());
            }
        }else{

            for(Map.Entry<String,String >entry:currentTsx.entrySet()){
                if(entry.getValue().equals(DELETED_MARKER)){
                    store.remove(entry.getKey());
                }else{
                    store.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

}
