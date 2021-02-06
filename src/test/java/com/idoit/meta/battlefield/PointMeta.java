package com.idoit.meta.battlefield;

import com.idoit.meta.Meta;

import java.util.Arrays;

public class PointMeta extends Meta {

    public PointMeta() {
        defaultConstructorParams = new Object[] {1, 2};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return PointLook.class;
    }

    @Override
    public PointLook getLook() {
        return new PointLook(1, 2);
    }

    @Override
    protected void initConstructors() {
        /*Arrays.stream(PointLook.class.getConstructors())
                .forEach(constructor -> {
                    Map<String, Class<?>> params = new HashMap<>();
                    Arrays.asList(constructor.getParameters())
                            .forEach(parameter -> params.put(parameter.getName(), parameter.getType()));
                    addConstructorWithParams(params);
                });*/
        addConstructorForFields(Arrays.asList("x", "y"));
    }

    public class PointLook extends Look {
        private int x;
        private int y;

        PointLook(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return (int) invokeOriginal();
        }

        public void setX(int x) {
            invokeOriginal(x);
        }

        public int getY() {
            return (int) invokeOriginal();
        }

        public void setY(int y) {
            invokeOriginal(y);
        }

        public void setXY(int x, int y) {
            invokeOriginal(x, y);
        }
    }
}
