
package movimientos;

import enums.EnumEntidades.DireccionEntidades;
import static enums.EnumEntidades.DireccionEntidades.*;
import enums.ubicacion.UbicacionBorde;
import java.util.Random;

public class MoverAlatorio implements InterfasDeMovimiento{
    
    GestorDeEntorno GestorDeEntorno;
    private int iteradorCambioDireccion=0;
    private final Random random = new Random();
    private int randomCambioDireccion  = random.nextInt(9)+1;
    private final Desplazador desplazador = new Desplazador();

    public MoverAlatorio( GestorDeEntorno GestorDeEntorno) {
        this.GestorDeEntorno = GestorDeEntorno;
    }
    private void reiniciarVariables(){
        
        iteradorCambioDireccion=0;
        randomCambioDireccion =random.nextInt(9)+1;
    }
    @Override
    public DireccionEntidades moverse(cordenadas posicionEntidad, DireccionEntidades DireccionEntidades) {
        UbicacionBorde detectarBorde = GestorDeEntorno.detectarBorde(posicionEntidad);
        DireccionEntidades nuevaDireccion=DireccionEntidades;
        
        if (detectarBorde !=UbicacionBorde.NINGUNO) {
            
            nuevaDireccion=detectarBorde.invertirDireccion(DireccionEntidades); 
            
        }else{
            int nextInt = random.nextInt(4);
            
            if(randomCambioDireccion*25==iteradorCambioDireccion){
                switch(nextInt){
                    case 0:
                        nuevaDireccion=DERECHA;
                        reiniciarVariables();
                        break;
                    case 1:
                        nuevaDireccion=ARRIBA;
                        reiniciarVariables();
                        break;
                    case 2:
                        nuevaDireccion=IZQUIERDA;
                        reiniciarVariables();
                        break;
                    case 3:
                        nuevaDireccion=ABAJO;
                        reiniciarVariables();
                        break;
                }
            }else{
                
                iteradorCambioDireccion++;
            } 
            
        }
        switch(nuevaDireccion){
            case ABAJO:desplazador.moverAbajo( posicionEntidad);break;
            case ARRIBA:desplazador.moverArriba( posicionEntidad);break;
            case DERECHA:desplazador.moverDerecha( posicionEntidad);break;
            case IZQUIERDA:desplazador.moverIzquierda( posicionEntidad);break;
        }
        return nuevaDireccion;
    }
    
   

}

/*

Rectangle as=new Rectangle(xc, yt, 100, 100);
        g2d.fill(as);
        GestorDeEntorno GestorDeEntorno= new GestorDeEntorno(datosDePrograma.getTamanioDeVentanaAncho(),datosDePrograma.getTamanioDeVentanaAlto());
        switch (GestorDeEntorno.detectarBorde(as)) {
            case NINGUNO:
                xc++;
                yt++;
                break;
            
        }
 private DireccionEntidades cambiarDireccion(int ubicacionX,int ubicacionY,EnumEntidades.DireccionEntidades DireccionEntidades){
        // Esquina superior-izquierda: redirige hacia el interior según dirección de entrada
        if (ubicacionX<=0 && ubicacionY<=0) {
            switch(DireccionEntidades){
                case IZQUIERDA: DireccionEntidades=ABAJO; break;   // venía hacia la esquina por X -> gira hacia abajo
                case ARRIBA: DireccionEntidades=DERECHA; break;    // venía hacia la esquina por Y -> gira hacia derecha
                // ABAJO y DERECHA no se contemplan en esta esquina
            }
        // Esquina inferior-derecha
        }else if(ubicacionX>=datosDePrograma.getScreenWidth()-25 && ubicacionY>=datosDePrograma.getScreenHeight()-25){
            switch(DireccionEntidades){
                case DERECHA: DireccionEntidades=ARRIBA; break;
                case ABAJO: DireccionEntidades=IZQUIERDA; break;
            }
        // Esquina inferior-izquierda
        }else if(ubicacionX<=0 && ubicacionY>=datosDePrograma.getScreenHeight()-25){
            switch(DireccionEntidades){
                case IZQUIERDA: DireccionEntidades=ARRIBA; break;
                case ABAJO: DireccionEntidades=DERECHA; break;
            }
        // Esquina superior-derecha
        }else if(ubicacionX>=datosDePrograma.getScreenWidth()-25 && ubicacionY<=0){//System.out.println("4");
            switch(DireccionEntidades){
                case DERECHA: DireccionEntidades=ABAJO; break;
                case ARRIBA: DireccionEntidades=IZQUIERDA; break;
            }
        // Borde izquierdo (sin estar en esquina): sorteo 0/1 decide entre dos direcciones posibles
        }else if(ubicacionX<=0){
            int NumeroAleatorio = random.nextInt(2); // 0 o 1
            switch(DireccionEntidades){
                case IZQUIERDA: // choque de frente contra el borde -> rebote perpendicular obligatorio
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=ARRIBA; break;
                        case 1: DireccionEntidades=ABAJO; break;
                    } break;
                case ARRIBA: // iba paralelo al borde -> puede mantenerse o girar hacia el interior
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=ARRIBA; break;  // mantiene
                        case 1: DireccionEntidades=DERECHA; break; // se aleja del borde
                    } break;  
                case ABAJO: // iba paralelo al borde -> puede mantenerse o girar hacia el interior
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=DERECHA; break; // se aleja del borde
                        case 1: DireccionEntidades=ABAJO; break;   // mantiene
                    } break;    
            }
        // Borde derecho (espejo del borde izquierdo)
        }else if(ubicacionX>=datosDePrograma.getScreenWidth()-25){
            int NumeroAleatorio = random.nextInt(2);
            switch(DireccionEntidades){
                case DERECHA: // choque de frente -> rebote perpendicular obligatorio
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=ARRIBA; break;
                        case 1: DireccionEntidades=ABAJO; break;
                    } break;
                case ABAJO: // paralelo al borde -> mantiene o se aleja
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=IZQUIERDA; break; // se aleja
                        case 1: DireccionEntidades=ABAJO; break;     // mantiene
                    } break;
                case ARRIBA: // paralelo al borde -> mantiene o se aleja
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=ARRIBA; break;    // mantiene
                        case 1: DireccionEntidades=IZQUIERDA; break; // se aleja
                    } break;
            }
        // Borde superior (mismo patrón, eje Y)
        }else if(ubicacionY<=0){
            int NumeroAleatorio = random.nextInt(2);
            switch(DireccionEntidades){
                case ARRIBA: // choque de frente -> rebote perpendicular obligatorio
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=DERECHA; break;
                        case 1: DireccionEntidades=IZQUIERDA; break;
                    } break;
                case IZQUIERDA: // paralelo al borde -> mantiene o se aleja
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=IZQUIERDA; break; // mantiene
                        case 1: DireccionEntidades=ABAJO; break;     // se aleja
                    } break;
                case DERECHA: // paralelo al borde -> mantiene o se aleja
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=DERECHA; break;   // mantiene
                        case 1: DireccionEntidades=ABAJO; break;     // se aleja
                    } break;    
            }
        // Borde inferior
        // NOTA: a diferencia de los otros 3 bordes, aquí ambas opciones del sorteo
        // resultan siempre en DERECHA para los 3 case, sin variación real (posible bug, no corregido aquí)
        }else if(ubicacionY>=datosDePrograma.getScreenHeight()-25){
            int NumeroAleatorio = random.nextInt(2);
            switch(DireccionEntidades){
                case ABAJO:
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=DERECHA; break;
                        case 1: DireccionEntidades=DERECHA; break;
                    } break;
                case DERECHA:
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=DERECHA; break;
                        case 1: DireccionEntidades=DERECHA; break;
                    } break;
                case IZQUIERDA:
                    switch(NumeroAleatorio){
                        case 0: DireccionEntidades=DERECHA; break;
                        case 1: DireccionEntidades=DERECHA; break;
                    } break;
            }
        // Zona central (ni borde ni esquina): cambio de dirección "espontáneo"
        }else{
            int NumeroAleatorio = random.nextInt(3);

            switch(DireccionEntidades){
            case ARRIBA:
                switch(NumeroAleatorio){
                    case 0: DireccionEntidades=DERECHA; break;
                    case 1: DireccionEntidades=IZQUIERDA; break;
                    case 2: DireccionEntidades=ARRIBA; break; // inalcanzable
                } break;
            case ABAJO:
                switch(NumeroAleatorio){
                    case 0: DireccionEntidades=DERECHA; break;
                    case 1: DireccionEntidades=IZQUIERDA; break;
                    case 2: DireccionEntidades=ABAJO; break; // inalcanzable
                } break;
            case IZQUIERDA:
                switch(NumeroAleatorio){
                    case 0: DireccionEntidades=ARRIBA; break;
                    case 1: DireccionEntidades=IZQUIERDA; break;
                    case 2: DireccionEntidades=ABAJO; break; // inalcanzable
                } break;
            case DERECHA:
                switch(NumeroAleatorio){
                    case 0: DireccionEntidades=DERECHA; break;
                    case 1: DireccionEntidades=ARRIBA; break;
                    case 2: DireccionEntidades=ABAJO; break; // inalcanzable
                   } break;
            }
        }  
        return DireccionEntidades;
    }

public DireccionEntidades moverse(int[] ubicacion, DireccionEntidades DireccionEntidades, Rectangle ubicacion2) {
        int ubicacionX = ubicacion[desplazador.xPosicion];
        int ubicacionY = ubicacion[desplazador.yPosicion];

        // Esquina superior-izquierda
        if (ubicacionX <= 0 && ubicacionY <= 0) {
            switch (DireccionEntidades) {
                case IZQUIERDA: DireccionEntidades = ABAJO; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                case ARRIBA: DireccionEntidades = DERECHA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
            }
        // Esquina inferior-derecha (usa ALTO/ANCHO invertidos respecto a X/Y)
        } else if (ubicacionX >= datosDePrograma.getTAMANIO_PANEL_ALTO() - 25 && ubicacionY >= datosDePrograma.getTAMANIO_PANEL_ANCHO() - 25) {
            switch (DireccionEntidades) {
                case DERECHA: DireccionEntidades = ARRIBA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                case ABAJO: DireccionEntidades = IZQUIERDA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
            }
        // Esquina inferior-izquierda
        } else if (ubicacionX <= 0 && ubicacionY >= datosDePrograma.getTAMANIO_PANEL_ALTO() - 25) {
            switch (DireccionEntidades) {
                case IZQUIERDA: DireccionEntidades = ARRIBA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                case ABAJO: DireccionEntidades = DERECHA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
            }
        // Esquina superior-derecha
        } else if (ubicacionX >= datosDePrograma.getTAMANIO_PANEL_ANCHO() - 25 && ubicacionY <= 0) {
            switch (DireccionEntidades) {
                case DERECHA: DireccionEntidades = ABAJO; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                case ARRIBA: DireccionEntidades = IZQUIERDA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
            }
        // Borde izquierdo: rebote hacia arriba o abajo al azar
        } else if (ubicacionX <= 0) {
            int nextInt = random.nextInt(2);
            switch (DireccionEntidades) {
                case IZQUIERDA:
                    switch (nextInt) {
                        case 0: DireccionEntidades = ARRIBA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                        case 1: DireccionEntidades = ABAJO; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                    } break;
            }
        // Borde derecho: rebote hacia arriba o abajo al azar
        } else if (ubicacionX >= datosDePrograma.getTAMANIO_PANEL_ANCHO() - 25) {
            int nextInt = random.nextInt(2);
            switch (DireccionEntidades) {
                case DERECHA:
                    switch (nextInt) {
                        case 0: DireccionEntidades = ARRIBA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                        case 1: DireccionEntidades = ABAJO; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                    } break;
            }
        // Borde superior: rebote hacia derecha o izquierda al azar
        } else if (ubicacionY <= 0) {
            int nextInt = random.nextInt(2);
            switch (DireccionEntidades) {
                case ARRIBA:
                    switch (nextInt) {
                        case 0: DireccionEntidades = DERECHA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                        case 1: DireccionEntidades = IZQUIERDA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                    } break;
            }
        // Borde inferior: rebote hacia derecha o izquierda al azar
        
        } else if (ubicacionY >= datosDePrograma.getTAMANIO_PANEL_ALTO() - 25) {
            int nextInt = random.nextInt(2);
            switch (DireccionEntidades) {
                case ABAJO:
                    switch (nextInt) {
                        case 0: DireccionEntidades = DERECHA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                        case 1: DireccionEntidades = IZQUIERDA; iteradorCambioDireccion = 0; randomCambioDireccion = random.nextInt(9) + 1; break;
                    } break;
            }
        }

        // Cambio de dirección espontáneo cada randomCambioDireccion*25 pasos (rango 25–225)
        if (randomCambioDireccion * 25 == iteradorCambioDireccion) {
            DireccionEntidades =cambiarDireccion(ubicacionX, ubicacionY, DireccionEntidades);
            iteradorCambioDireccion = 0;
            randomCambioDireccion = random.nextInt(9) + 1;
        } else {
            // Aún no llega al umbral: avanza el contador y mueve en la dirección actual
            iteradorCambioDireccion++;
            switch (DireccionEntidades) {
                case ABAJO: desplazador.moverAbajo(ubicacion, ubicacion2); break;
                case ARRIBA: desplazador.moverArriba(ubicacion, ubicacion2); break;
                case DERECHA: desplazador.moverDerecha(ubicacion, ubicacion2); break;
                case IZQUIERDA: desplazador.moverIzquierda(ubicacion, ubicacion2); break;
            }
        }
        return DireccionEntidades;
        
    }
    


*/
/*
    private void cambiarDireccion2(int ubicacionX,int ubicacionY,EnumEntidades.DireccionEntidades DireccionEntidades){
        
        if (ubicacionX<=0&&ubicacionY<=0) {
            switch(DireccionEntidades){
                case IZQUIERDA:DireccionEntidades=ABAJO; break;
                case ARRIBA:DireccionEntidades=DERECHA; break;
            }
        }else if(ubicacionX>=datosDePrograma.getScreenWidth()-25&&ubicacionY>=datosDePrograma.getScreenHeight()-25){
            switch(DireccionEntidades){
                case DERECHA:DireccionEntidades=ARRIBA; break;
                case ABAJO:DireccionEntidades=IZQUIERDA;break;
            }
        }else if(ubicacionX<=0&&ubicacionY>=datosDePrograma.getScreenHeight()-25){
            switch(DireccionEntidades){
                case IZQUIERDA:DireccionEntidades=ARRIBA; break;
                case ABAJO:DireccionEntidades=DERECHA; break;
            }
        }else if(ubicacionX>=datosDePrograma.getScreenWidth()-25&&ubicacionY<=0){//System.out.println("4");
            switch(DireccionEntidades){
                case DERECHA:DireccionEntidades=ABAJO; break;
                case ARRIBA:DireccionEntidades=IZQUIERDA;break;
            }
        }else if(ubicacionX<=0){
            int NumeroAleatorio = random.nextInt(2);
            switch(DireccionEntidades){
                case IZQUIERDA:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=ARRIBA; break;
                        case 1:DireccionEntidades=ABAJO;break;
                    } break;
                case ARRIBA:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=ARRIBA; break;
                        case 1:DireccionEntidades=DERECHA;break;
                    } break;  
                case ABAJO:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=DERECHA; break;
                        case 1:DireccionEntidades=ABAJO;break;
                    } break;    
            }
        }else if(ubicacionX>=datosDePrograma.getScreenWidth()-25){
        int NumeroAleatorio = random.nextInt(2);
            switch(DireccionEntidades){
                case DERECHA:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=ARRIBA;break;
                    case 1:DireccionEntidades=ABAJO;break;
                }break;
                case ABAJO:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=IZQUIERDA; break;
                        case 1:DireccionEntidades=ABAJO;break;
                    } break;
                case ARRIBA:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=ARRIBA; break;
                        case 1:DireccionEntidades=IZQUIERDA;break;
                    } break;
                 
                    
            }
        }else if(ubicacionY<=0){
            int NumeroAleatorio = random.nextInt(2);
            switch(DireccionEntidades){
                case ARRIBA:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=DERECHA; break;
                        case 1:DireccionEntidades=IZQUIERDA;break;
                    }break;
                case IZQUIERDA:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=IZQUIERDA; break;
                        case 1:DireccionEntidades=ABAJO;break;
                    } break;
                case DERECHA:
                    switch(NumeroAleatorio){
                        case 0:DireccionEntidades=DERECHA; break;
                        case 1:DireccionEntidades=ABAJO;break;
                    } break;    
                    
            }
                    
        }else if(ubicacionY>=datosDePrograma.getScreenHeight()-25){
            int NumeroAleatorio = random.nextInt(2);
            switch(DireccionEntidades){
                case ABAJO:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=DERECHA; break;
                    case 1:DireccionEntidades=DERECHA;break;
                }break;
                case DERECHA:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=DERECHA; break;
                    case 1:DireccionEntidades=DERECHA;break;
                }break;
                case IZQUIERDA:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=DERECHA; break;
                    case 1:DireccionEntidades=DERECHA;break;
                }break;
            }
                
        }else{
            int NumeroAleatorio = random.nextInt(3);
            switch(DireccionEntidades){
            case ARRIBA:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=DERECHA;break;
                    case 1:DireccionEntidades=IZQUIERDA;break;
                    case 3:DireccionEntidades=ARRIBA;break;
                }break;
            case ABAJO:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=DERECHA;break;
                    case 1:DireccionEntidades=IZQUIERDA;break;
                    case 3:DireccionEntidades=ABAJO;break;
                }break;
            case IZQUIERDA:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=ARRIBA;break;
                    case 1:DireccionEntidades=IZQUIERDA;break;
                    case 3:DireccionEntidades=ABAJO;break;
                }break;
            case DERECHA:
                switch(NumeroAleatorio){
                    case 0:DireccionEntidades=DERECHA;break;
                    case 1:DireccionEntidades=ARRIBA;break;
                    case 3:DireccionEntidades=ABAJO;break;
                }break;
            }
        }
    } 
    */