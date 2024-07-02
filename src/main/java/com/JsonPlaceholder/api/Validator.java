package com.JsonPlaceholder.api;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;


public class Validator {
    private final Schema schema;

    public Validator(String schemaFilePath) throws Exception {
        BufferedReader schemaReader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(this.getClass().getResourceAsStream("/" + schemaFilePath))));
        JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaReader));
        this.schema = SchemaLoader.load(jsonSchema);
    }


    public void validate(String validationTarget) {
        if (validationTarget == null) {
            throw new NullPointerException("jsonData is null");
        }

        if (validationTarget.startsWith("[")) {
            validate(new JSONArray(validationTarget));
        } else {
            validate(new JSONObject(new JSONTokener(validationTarget)));
        }
    }

    private void validate(JSONObject validationTarget) {
        schema.validate(validationTarget);
    }

    private void validate(JSONArray validationTargets) {
        for (Object element : validationTargets) {
            schema.validate(element);
        }
    }

}
