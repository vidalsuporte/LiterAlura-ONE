package br.com.vidalsuporte.literalura.service;

public interface IConverteDados {

    <T> T converteDados(String json, Class<T> classe);




}
