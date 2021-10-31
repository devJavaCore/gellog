package br.com.gellog.util;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum TipoVeiculo {
	SELECIONAR("Selecionar"), CAMINHAO("Caminhão"), FURGAO("Furgão"), MUNK("Munk"), PASSEIO("Passeio"), VAN("Van");  
	 private String name;

    private static final Map<String,TipoVeiculo> ENUM_MAP;

    TipoVeiculo (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    static {
        Map<String,TipoVeiculo> map = new ConcurrentHashMap<String, TipoVeiculo>();
        for (TipoVeiculo instance : TipoVeiculo.values()) {
            map.put(instance.getName().toLowerCase(),instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static TipoVeiculo get (String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }
}
