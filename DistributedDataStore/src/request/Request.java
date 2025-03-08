package request;

import java.io.Serializable;
import storage.Storage;

public interface Request<R> extends Serializable {
    R handle(Storage storage);
}