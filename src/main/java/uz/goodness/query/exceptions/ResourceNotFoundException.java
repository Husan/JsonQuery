package uz.goodness.query.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.ObjectStreamClass;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = ObjectStreamClass.lookup(ResourceNotFoundException.class).getSerialVersionUID();
    private String resourceCode;
    private String resourceName;
    private Object resource;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
