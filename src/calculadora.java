import java.util.Scanner;    
public class calculadora {    
    public static void main (String args[]){   
   
        short operacao;
        double numero1, numero2;    
        try (Scanner input = new Scanner(System.in)) {
            do {
                 System.out.println("Digite a operacao desejada:");
                 System.out.println("  1. Soma");      
                 System.out.println("  2. Subtracao");      
                 System.out.println("  3. Multiplicacao");      
                 System.out.println("  4. Divisao");
                 System.out.println("  5. Porcentagem");      
                 System.out.println("  0. Voltar");
                 System.out.print("Operacao: ");
                 operacao = input.nextShort();
                 
                 if (operacao == 0) {
                	 System.out.println("Adeus!");
                	 break;
                 }
                 
                 if (!OperacaoExiste(operacao)) {
                	 continue;
                 }
                 
                 System.out.print("Digite o primeiro valor: ");
                 numero1 = input.nextDouble();
                 
                 System.out.print("Digite o segundo valor: ");
                 numero2 = input.nextDouble();
                 
                 if (!dadosDeEntrada(operacao, numero1, numero2)) {
                	 continue;
                 }
            
                 System.out.println("RESULTADO: O resultado da operacao " + getNomeOperacao(operacao) + " é " + Calcular(operacao, numero1, numero2) + "\n");
            } while (operacao != 0);
        }
    }
    
    static double Calcular (short operacao, double numero1, double numero2) {
    	double resultado = 0;
    	switch (operacao) {
    		
            //soma
            case 1:
    			resultado = numero1 + numero2;
    			break;

            //subtração    
    		case 2:
    			resultado = numero1 - numero2;
    			break;

            //multiplicação    
    		case 3:
    			resultado = numero1 * numero2;
    			break;

            //divisão    
    		case 4:
    			resultado = numero1 / numero2;
    			break;
            
    	}
    	return resultado;
    }
    
    static boolean OperacaoExiste (short operacao) {
       	boolean retorno = true;
    	if (operacao > 4) {
       		System.out.println("ERRO: Operacao escolhida eh invalida.\n");
       		retorno = false;
       	}
    	return retorno;
    }
    
    static boolean dadosDeEntrada (short operacao, double numero1, double numero2) {
    	boolean retorno = true; 
    	if (operacao == 4 & numero2 == 0) {
        	 System.out.println("ERRO: Divisor nao pode ser zero.\n");
        	 retorno = false;
        }
    	return retorno;
    }
    
    static String getNomeOperacao (short operacao) {
    	
    	switch (operacao) {
		case 1:
			return "soma";
		case 2:
			return "subtracao";
		case 3: 
			return "multiplicacao";
		case 4: 
			return "divisao";
        case 5:
            return "Porcentagem";
    	default:
    		return "undefined";
    	}
    	
    }
} 
