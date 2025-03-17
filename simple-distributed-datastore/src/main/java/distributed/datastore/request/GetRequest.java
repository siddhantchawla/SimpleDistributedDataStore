package distributed.datastore.request;

import distributed.datastore.storage.Storage;

public class GetRequest implements Request<String> {
    private String key;

    public GetRequest(String key){
        this.key = key;
    }

    @Override public String handle(Storage storage){
        return storage.get(key);
    }
}
