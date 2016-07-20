/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocomplejidad;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import lpsolve.*;



/**
 *
 * @author Alkomprar
 */

public class ProyectoComplejidad {

    /**
     * @param args the command line arguments
     */
    int meses,produccion_estimada, valor_bulto;
    int[] vector_temperatura,vector_precipitacion, vector_demanda_minima,vector_demanda_maxima;
    double[] ganancias; //ganancias calculadas para cada uno de los meses
    List<String> condiciones; //condiciones que seran agregadas al solver
    
    public ProyectoComplejidad() throws IOException{
        meses=0;
        produccion_estimada=0;
        valor_bulto=0;
        condiciones = new ArrayList<String>();
        Leer_archivo("datosPruebaEntrada3Tam20.txt");
    }    
    
    private void Leer_archivo(String nombre_archivo) throws FileNotFoundException, IOException{
        String aux_temperatura,aux_precipitacion,aux_demanda_minima,aux_demanda_maxima="";
        
        FileReader f = new FileReader(nombre_archivo);
        BufferedReader b = new BufferedReader(f);
        meses = Integer.parseInt(b.readLine());
        vector_temperatura = new int[meses];
        vector_precipitacion = new int[meses];
        vector_demanda_minima = new int[meses];
        vector_demanda_maxima = new int[meses];
        ganancias = new double[meses];
        
        aux_temperatura = b.readLine();
        aux_precipitacion = b.readLine();
        aux_demanda_minima = b.readLine();
        aux_demanda_maxima = b.readLine();
        produccion_estimada =  Integer.parseInt(b.readLine());
        valor_bulto = Integer.parseInt(b.readLine());
        
        //Dividir las lineas de temperatura, precicipation y demandas en tokens para poder trabajar con ellos individualemnte
        StringTokenizer tokens_t = new StringTokenizer(aux_temperatura);
        StringTokenizer tokens_p = new StringTokenizer(aux_precipitacion);
        StringTokenizer tokens_dmin = new StringTokenizer(aux_demanda_minima);
        StringTokenizer tokens_dmax = new StringTokenizer(aux_demanda_maxima);
        
        for (int i = 0 ; i < meses ; i++){
            vector_temperatura[i] = Integer.parseInt(tokens_t.nextToken());
            vector_precipitacion[i] = Integer.parseInt(tokens_p.nextToken());
            vector_demanda_minima[i] = Integer.parseInt(tokens_dmin.nextToken());
            vector_demanda_maxima[i] = Integer.parseInt(tokens_dmax.nextToken());
        }
        
    }
    
    public void Mostrar_datos(){
        System.out.println("Meses: "+meses);
        System.out.println("temperatura: ");
        for (int i = 0 ; i < meses ; i++){
            System.out.println(vector_temperatura[i]);            
        }
        System.out.println("precipitacion: ");
        for (int i = 0 ; i < meses ; i++){
            System.out.println(vector_precipitacion[i]);  
        }
        System.out.println("demanda minima: ");
        for (int i = 0 ; i < meses ; i++){
            System.out.println(vector_demanda_minima[i]);  
        }
        System.out.println("demanda maxima: ");
        for (int i = 0 ; i < meses ; i++){
            System.out.println(vector_demanda_maxima[i]);  

        }
        System.out.println("Produccion estimada: "+produccion_estimada);
        System.out.println("Valor bulto: "+valor_bulto);
    }
    
    public void calcularGanancia(){
        //CALCULO DE LAS GANACIAS POR MES
        for(int i = 0; i < meses ; i++){
            if(produccion_estimada < vector_demanda_minima[i]){
                ganancias[i] = valor_bulto*produccion_estimada*0.5;              
            }else{
                if(produccion_estimada <= vector_demanda_maxima[i]){
                    ganancias[i] = valor_bulto*produccion_estimada;
                }else{
                    ganancias[i] = (valor_bulto*vector_demanda_maxima[i]) + (valor_bulto*0.5*(produccion_estimada-vector_demanda_maxima[i]));
                }
                
            }
            System.out.print("Ganacia mes " + (i+1) + " : " + ganancias[i]+ "\n");            
        }
    }
    
    public void condicion4meses(){
        int[] arreglo_condicion = new int[meses];
        
        //Condiciones decision siembra y 4 meses de cultivo
        System.out.println("==========CONDICIONES CULTIVO DURA 4 MESES==========");
        for(int i = 0 ; i < meses ; i++){
            arreglo_condicion[i] = 0; 
        }
        
        String condicion_meses = "";
        for(int i = 0; i < meses-3 ; i++){
            arreglo_condicion[i] = 1;
            arreglo_condicion[i+1] = 1;
            arreglo_condicion[i+2] = 1;
            arreglo_condicion[i+3] = 1;
            for(int j = 0 ; j < meses ; j++){
                condicion_meses += ""+arreglo_condicion[j]+" ";
            }
            System.out.println(condicion_meses);
            condiciones.add(condicion_meses); //<============ Condicion agregada cultivo de meses
            
            condicion_meses = "";
            for(int h = 0 ; h < meses ; h++){
                arreglo_condicion[h] = 0; 
            }
        }
    }
    
    public void condicionesTiempo(){
        String condicion_meses_no_siembra ="";
        int[] arreglo_condicion = new int[meses];
        for(int i = 0 ; i < meses ; i++){
            arreglo_condicion[i] = 0; 
        }
        System.out.println("==========CONDICIONES MESES EN LOS QUE NO SE CULTIVA==========");
        for(int i = 3; i < meses ; i++){
            if(vector_temperatura[i-3] > 20  || vector_temperatura[i-3] < 18 || vector_precipitacion[i-3] < 63){
                System.out.print("No se puede cosechar en el mes: " + (i) + "\n");
                
                arreglo_condicion[i] = 1; 
                for(int j = 0 ; j < meses ; j++){
                    condicion_meses_no_siembra += ""+arreglo_condicion[j]+" ";
                }
                System.out.println(condicion_meses_no_siembra);
                condiciones.add(condicion_meses_no_siembra); // <============ Condicion de imposibilidad de cultivo agregada
                
                condicion_meses_no_siembra = "";
                for(int h = 0 ; h < meses ; h++){
                    arreglo_condicion[h] = 0; 
                }
            }
        }
    }
    
    public void condicionPrimerosMeses(){
        int[] arreglo_condicion = new int[meses];
        System.out.println("==========CONDICIONES NO SE PUEDE COSECHAR EN LOS PRIMEROS 3 MESES==========");
        //Condicion no se puede sembrar en los ultimos 3 meses porque no se alcanzaria a recoger la cosecha
        String condicion_primeros_meses ="";
        for(int i = 0 ; i < meses ; i++){
            arreglo_condicion[i] = 0; 
        }
        
        for(int i=0; i<3 ; i++){
            arreglo_condicion[i]=1;
            for(int j = 0 ; j < meses ; j++){
                condicion_primeros_meses += ""+arreglo_condicion[j]+" ";
            }
            condiciones.add(condicion_primeros_meses); 
            condicion_primeros_meses="";
        }        
    }
    
    public void Preprocesamiento(){
        
//        //CALCULO DE LAS GANACIAS POR MES
//        for(int i = 0; i < meses ; i++){
//            if(produccion_estimada < vector_demanda_minima[i]){
//                ganancias[i] = valor_bulto*produccion_estimada*0.5;              
//            }else{
//                if(produccion_estimada <= vector_demanda_maxima[i]){
//                    ganancias[i] = valor_bulto*produccion_estimada;
//                }else{
//                    ganancias[i] = (valor_bulto*vector_demanda_maxima[i]) + (valor_bulto*0.5*(produccion_estimada-vector_demanda_maxima[i]));
//                }
//                
//            }
//            System.out.print("Ganacia mes " + (i+1) + " : " + ganancias[i]+ "\n");            
//        }
        calcularGanancia();

//        
//        //Condiciones decision siembra y 4 meses de cultivo
//        System.out.println("==========CONDICIONES CULTIVO DURA 4 MESES==========");
//        for(int i = 0 ; i < meses ; i++){
//            arreglo_condicion[i] = 0; 
//        }
//        
//        String condicion_meses = "";
//        for(int i = 0 ; i < meses-3 ; i++){
//            arreglo_condicion[i] = 1;
//            arreglo_condicion[i+1] = 1;
//            arreglo_condicion[i+2] = 1;
//            arreglo_condicion[i+3] = 1;
//            for(int j = 0 ; j < meses ; j++){
//                condicion_meses += ""+arreglo_condicion[j]+" ";
//            }
//            System.out.println(condicion_meses);
//            condiciones.add(condicion_meses); //<============ Condicion agregada cultivo de meses
//            
//            condicion_meses = "";
//            for(int h = 0 ; h < meses ; h++){
//                arreglo_condicion[h] = 0; 
//            }
//        }
        
        condicion4meses();
        condicionesTiempo();
        
        //EVALUAR EN QUE MESES NO SE PUEDE SEMBRAR POR CONDICIONES INICIALES, por lo cual esta restriccion
        //se añadira a simplex por medio de la condicion Mesi = 0 -> que significa que no hay siembra en dicho mes
       
        
//        String condicion_meses_no_siembra ="";
//        
//        System.out.println("==========CONDICIONES MESES EN LOS QUE NO SE CULTIVA==========");
//        for(int i = 3; i < meses ; i++){
//            if(vector_temperatura[i-3] > 20  || vector_temperatura[i-3] < 18 || vector_precipitacion[i-3] < 63){
//                System.out.print("No se puede sembrar en el mes: " + (i-2) + "\n");
//                
//                arreglo_condicion[i] = 1; 
//                for(int j = 0 ; j < meses ; j++){
//                    condicion_meses_no_siembra += ""+arreglo_condicion[j]+" ";
//                }
//                System.out.println(condicion_meses_no_siembra);
//                condiciones.add(condicion_meses_no_siembra); // <============ Condicion de imposibilidad de cultivo agregada
//                
//                condicion_meses_no_siembra = "";
//                for(int h = 0 ; h < meses ; h++){
//                    arreglo_condicion[h] = 0; 
//                }
//                //Aqui se debe hacer algo para adicionar esta restriccion a simplex
//            }
//        }
//        
//        System.out.println("==========CONDICIONES NO SE PUEDE COSECHAR EN LOS PRIMEROS 3 MESES==========");
//        //Condicion no se puede sembrar en los ultimos 3 meses porque no se alcanzaria a recoger la cosecha
//        String condicion_primeros_meses ="";
//        for(int i = 0 ; i < meses ; i++){
//            arreglo_condicion[i] = 0; 
//        }
//        
//        for(int i=0; i<3 ; i++){
//            arreglo_condicion[i]=1;
//            for(int j = 0 ; j < meses ; j++){
//                condicion_primeros_meses += ""+arreglo_condicion[j]+" ";
//            }
//            condiciones.add(condicion_primeros_meses); 
//            condicion_primeros_meses="";
//        }       
//        
        condicionPrimerosMeses();
    }
    
    public void Solucionar(){
        try {
            // Create a problem with variables and  constraints
            int cantidad_de_condiciones = condiciones.size();
            System.out.println("Numero de Condiciones: "+cantidad_de_condiciones);
            LpSolve solver = LpSolve.makeLp(cantidad_de_condiciones, meses);
            for (int s =1 ; s<=meses;s++){
                solver.setBinary(s, true);
            }

            // add constraints 4 meses
            for(int i = 0 ; i < meses-3; i++){
                solver.strAddConstraint(condiciones.get(i), LpSolve.LE, 1);
            }
            //remaining
            for(int i = meses-3 ; i<cantidad_de_condiciones; i++){
                 solver.strAddConstraint(condiciones.get(i), LpSolve.EQ, 0);
            }

            solver.setMaxim();
            
            int tamanio_ganancias = ganancias.length;
            String FO = "";
            
            for(int i = 0; i<tamanio_ganancias; i++){
                FO += ganancias[i]+" ";
            }
            System.out.println("Funcion Maximixar: "+FO);
            //solver.strSetObjFn("5850000 2925000 5850000 2925000 5850000 0 0 0");
            solver.strSetObjFn(FO);

            // solve the problem
            solver.solve();

            // print solution
            System.out.println("Value of objective function: " + solver.getObjective());
            double[] var = solver.getPtrVariables();
            for (int i = 0; i < var.length; i++) {
              System.out.println("Value of var[" + i + "] = " + var[i]);
            }

            // delete the problem and free memory
            solver.deleteLp();
          }
          catch (LpSolveException e) {
          }
     }
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ProyectoComplejidad miProyecto = new ProyectoComplejidad();
        //miProyecto.Mostrar_datos();
        miProyecto.Preprocesamiento();
        miProyecto.Solucionar();
    }
    
}
