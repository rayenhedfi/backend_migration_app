

package tn.actia.pfe.Pfe_App.Gitlab;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Visibilite {
    PUBLIC("public"),
    PRIVATE("private"),
    INTERNAL("internal");

    private final String value;

    Visibilite(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Visibilite fromValue(String value) {
        for (Visibilite visibilite : values()) {
            if (visibilite.value.equalsIgnoreCase(value)) {
                return visibilite;
            }
        }
        throw new IllegalArgumentException("Invalid Visibilite value: " + value);
    }
}
