
package imprimir;

import javax.swing.JOptionPane;

public class Imprimir {

    //*****************************************************************************//
    
    private static String imp(StackTraceElement[] llamadasALaClase){
        String salida;
        if (llamadasALaClase.length>2) {
            String nombre_de_clase=llamadasALaClase[2].getClassName();
            salida=(" ====> |"+nombre_de_clase+"|"+" ====> |"+llamadasALaClase[2].getMethodName());
        }else{
            salida="error: llamadasALaClase clase Imprimir";
        }
        
        return salida;
    }
    public static void mostrarEnConsolaln(String parametro){
        StackTraceElement[] llamadasALaClase= Thread.currentThread().getStackTrace();
        String imp = imp(llamadasALaClase);
        
        System.out.println(parametro+imp+"|");
    } 
    public static void mostrarEnConsolaln(Float parametro){
        StackTraceElement[] llamadasALaClase= Thread.currentThread().getStackTrace();
        String imp = imp(llamadasALaClase);
        
        System.out.println(parametro+imp+"|");
    } 
    public static void mostrarEnConsolaln(boolean parametro){
        StackTraceElement[] llamadasALaClase= Thread.currentThread().getStackTrace();
        String imp = imp(llamadasALaClase);
        
        System.out.println(parametro+imp+"|");
    } 
    public static void mostrarEnConsolaln(int parametro){
        StackTraceElement[] llamadasALaClase= Thread.currentThread().getStackTrace();
        String imp = imp(llamadasALaClase);
        
        System.out.println(parametro+imp+"|");
    } 
    //*****************************************************************************//
    public static void mostrarEnConsola(String parametro){
        StackTraceElement[] l= Thread.currentThread().getStackTrace();
        if (l.length>2) {
            String kji=l[2].getClassName();
            System.out.print(l[2].getMethodName());
            System.out.print("|"+kji+"|"+" ====> |"+parametro+"|");
        }else{
            System.out.print(parametro);
        }
    }  
    public static void mostrarEnConsola(Float parametro){
        StackTraceElement[] l= Thread.currentThread().getStackTrace();
        if (l.length>2) {
            String kji=l[2].getClassName();
            System.out.print(l[2].getMethodName());
            System.out.print("|"+kji+"|"+" ====> |"+parametro+"|");
        }else{
            System.out.print(parametro);
        }
    } 
    public static void mostrarEnConsola(boolean parametro){
        StackTraceElement[] l= Thread.currentThread().getStackTrace();
        if (l.length>2) {
            String kji=l[2].getClassName();
            System.out.print(l[2].getMethodName());
            System.out.print("|"+kji+"|"+" ====> |"+parametro+"|");
        }else{
            System.out.print(parametro);
        }
    } 
    public static void mostrarEnConsola(int parametro){
        StackTraceElement[] l= Thread.currentThread().getStackTrace();
        if (l.length>2) {
            String kji=l[2].getClassName();
            System.out.print(l[2].getMethodName());
            System.out.print("|"+kji+"|"+" ====> |"+parametro+"|");
        }else{
            System.out.print(parametro);
        }
    } 
    //*****************************************************************************//
    public static void mostrarEnConsolaSimpleln(String parametro){
        System.out.println(parametro);
    } 
    public static void mostrarEnConsolaSimpleln(Float parametro){
        System.out.println(parametro);
    } 
    public static void mostrarEnConsolaSimpleln(boolean parametro){
        System.out.println(parametro);
    } 
    public static void mostrarEnConsolaSimpleln(int parametro){
        System.out.println(parametro);
    } 
    //*****************************************************************************//
    public static void mostrarEnConsolaSimple(String parametro){
        System.out.print(parametro);
    } 
    public static void mostrarEnConsolaSimple(Float parametro){
        System.out.print(parametro);
    } 
    public static void mostrarEnConsolaSimple(boolean parametro){
        System.out.print(parametro);
    } 
    public static void mostrarEnConsolaSimple(int parametro){
        System.out.print(parametro);
    } 
    //*****************************************************************************//
    
    //*****************************************************************************//
    public static void mostrarEnAlerta(String parametro){
        JOptionPane.showMessageDialog(null, parametro); 
    }
    public static void showMessageDialog(){
        
    }   
}
        
        
        
        
/*

public static void mostrarEnConsolaln(String parametro){
        StackTraceElement[] llamadasALaClase= Thread.currentThread().getStackTrace();
        String imp = imp(llamadasALaClase);
        
        System.out.println(parametro+imp+"|");
    } 
    public static void mostrarEnConsolaln(Float parametro){
        StackTraceElement[] l= Thread.currentThread().getStackTrace();
        if (l.length>2) {
            String kji=l[2].getClassName();
            System.out.println(l[2].getMethodName());
            System.out.println("|"+kji+"|"+" ====> |"+parametro+"|");
        }else{
            System.out.println(parametro);
        }
    } 
    public static void mostrarEnConsolaln(boolean parametro){
        StackTraceElement[] l= Thread.currentThread().getStackTrace();
        if (l.length>2) {
            String kji=l[2].getClassName();
            System.out.println(l[2].getMethodName());
            System.out.println("|"+kji+"|"+" ====> |"+parametro+"|");
        }else{
            System.out.println(parametro);
        }
    } 
    public static void mostrarEnConsolaln(int parametro){
        StackTraceElement[] l= Thread.currentThread().getStackTrace();
        if (l.length>2) {
            String kji=l[2].getClassName();
            System.out.println(l[2].getMethodName());
            System.out.println("|"+kji+"|"+" ====> |"+parametro+"|");
        }else{
            System.out.println(parametro);
        }
    } 


*/
