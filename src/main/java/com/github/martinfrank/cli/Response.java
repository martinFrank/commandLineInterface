package com.github.martinfrank.cli;

public class Response {


    private final String message;
    private final String details;
    private final Type type;

    private Response(Type type, String message, String details) {
        this.type = type;
        this.message = message;
        this.details = details;

    }

    public static Response fail(String message) {
        return fail(message, "");
    }

    public static Response fail(String message, String details) {
        return response(Type.FAILURE, message, details);
    }

    private static Response response(Type type, String message, String details) {
        return new Response(type, message, details);
    }

    public static Response success() {
        return success("ok", "");
    }

    public static Response success(String message) {
        return success(message, "");
    }

    public static Response success(String message, String details) {
        return response(Type.SUCCESS, message, details);
    }

    public boolean failed() {
        return type == Type.FAILURE;
    }

    @Override
    public String toString() {
        return type.toString() + ":" + message + (details.isEmpty() ? "" : " Details: " + details);

    }

    private enum Type {SUCCESS, FAILURE}
}
