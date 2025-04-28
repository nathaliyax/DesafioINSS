package krl_de_java;

import java.util.Scanner;

public class desafio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite o salário bruto: R$ ");
        double salarioBruto = scanner.nextDouble();
       
        System.out.print("Número de dependentes: ");
        int numDependentes = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Tipo do plano de saúde (Básico/Avançado/Nenhum): ");
        String tipoPlanoSaude = scanner.nextLine();
        
        System.out.print("Utiliza Vale Transporte? (Sim/Não): ");
        String valeTransporte = scanner.nextLine();
        
        System.out.print("Utiliza Vale Alimentação? (Sim/Não): ");
        String valeAlimentacao = scanner.nextLine();
        
        System.out.print("Utiliza Vale Refeição? (Sim/Não): ");
        String valeRefeicao = scanner.nextLine();

        
        double inss;
        
        if (salarioBruto <= 1302.00) {
            inss = salarioBruto * 0.08;
            
        } else if (salarioBruto <= 2571.00) {
            inss = salarioBruto * 0.09;
            
        } else if (salarioBruto <= 3856.00) {
            inss = salarioBruto * 0.11;
            
        } else {
            inss = salarioBruto * 0.14;
        }
        
        if (salarioBruto > 7087.22) {
            inss = 570.88;
        }

        double deducaoDependentes = numDependentes * 189.59;
        double baseImpR = salarioBruto - inss - deducaoDependentes;
        
        double ir;
        if (baseImpR <= 1903.98) {
            ir = 0;
        } else if (baseImpR<= 2826.65) {
            ir = (baseImpR * 0.075) - 142.80;
        } else if (baseImpR <= 3751.05) {
            ir = (baseImpR * 0.15) - 354.80;
        } else if (baseImpR <= 4664.68) {
            ir = (baseImpR * 0.225) - 636.13;
        } else {
            ir = (baseImpR * 0.275) - 869.36;
        }

        double vt = valeTransporte.equalsIgnoreCase("Sim") ? salarioBruto * 0.06 : 0;
        double va = valeAlimentacao.equalsIgnoreCase("Sim") ? 200.00 : 0;
        double vr = valeRefeicao.equalsIgnoreCase("Sim") ? 250.00 : 0;
        
        double plano;
        if (tipoPlanoSaude.equalsIgnoreCase("Básico")) {
            plano = 150.00;
            
        } else if (tipoPlanoSaude.equalsIgnoreCase("Avançado")) {
            plano = 300.00;
            
        } else {
            plano = 0;
        }

        
        double salarioLiquido = salarioBruto - inss - ir - vt - va - vr - plano;
        double totalDescontos = salarioBruto - salarioLiquido;
        double percentualDescontos = (totalDescontos / salarioBruto) * 100;

        
        System.out.printf("resultado:");
        System.out.printf("Salário Líquido: R$ %.2f%n", salarioLiquido);
        System.out.printf("Percentual de descontos: %.2f%%%n", percentualDescontos);
        System.out.printf("detalhamento dos descontos:");
        System.out.printf("- INSS: R$ %.2f%n", inss);
        System.out.printf("- Imposto de rends : R$ %.2f%n", ir);
        System.out.printf("- Vale Transporte: R$ %.2f%n", vt);
        System.out.printf("- Vale Alimentação: R$ %.2f%n", va);
        System.out.printf("- Vale Refeição: R$ %.2f%n", vr);
        System.out.printf("- plano de Saúde: 12", plano);
        
        scanner.close();
    }
    {

	}

}
