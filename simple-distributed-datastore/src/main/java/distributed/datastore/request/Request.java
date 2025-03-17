package distributed.datastore.request;

import java.io.Serializable;
import distributed.datastore.storage.Storage;

public interface Request<R> extends Serializable {
    R handle(Storage storage);
}