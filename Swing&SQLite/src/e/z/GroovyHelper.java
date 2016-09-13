package e.z;

import java.math.BigDecimal;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

public class GroovyHelper {

    public static void main(String[] args) throws Exception {

        StringBuffer sb = new StringBuffer();
        //�������
        sb.append("def p1=0;");
        sb.append("def p2=0;");
        sb.append("def res=0;");
        //���巽�� �޲���
        sb.append("def add(){ return p1+p2 ;};");
        //���巽�� �в���
        sb.append("def div(Object p1,Object p2){println p2/p1; res= p2/p1 ;};");
        sb.append(" def main(){ res=add(); }");
        //������
        String jsStr = "class GroovyQuot{" + sb.toString() + "}";
        System.out.println(jsStr);
        //������
        GroovyClassLoader loader = new GroovyClassLoader();
        Class<?> newClazz = loader.parseClass(jsStr);
        //ʵ������
        GroovyObject clazzObj = (GroovyObject) newClazz.newInstance();
        //��ֵ
        clazzObj.setProperty("p1", 2);
        clazzObj.setProperty("p2", 1);
        //invoke���� �޲���
        clazzObj.invokeMethod("main", null);
        //ȡֵ
        int res = (int) clazzObj.getProperty("res");
        System.out.println("main :res=" + res);

        int p1=(int)(clazzObj.getProperty("p1"));
        int p2=(int)(clazzObj.getProperty("p2"));
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);
        //invoke���� �в���
        clazzObj.invokeMethod("div", new Object[]{p1,p2});
        BigDecimal res2 = (BigDecimal)clazzObj.getProperty("res");
        System.out.println("div :res=" + res2);
    }
}