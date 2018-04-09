package com.company.haaphoop.thinkingInJava.chapter17;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class Countries {
    public static final String[][] DATA = {{}, {}};

    private static class FlyweightMap extends AbstractMap<String, String> {
        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return null;
        }

        private static class Entry implements Map.Entry<String, String> {
            int index;

            public Entry(int index) {
                this.index = index;
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index].equals(obj);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }
    }
}
