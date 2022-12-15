package tripboat.tripboat1.Util;

import lombok.Builder;

import java.io.Serializable;

public class SessionUser implements Serializable {
    private String name;

    @Builder
    public SessionUser (String name) {
        this.name = name;
    }

}
