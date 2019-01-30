package pingamesapi.service.utils;

public class CpfAndCnpj {
	private static final int[] PESO_CPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] PESO_CNPJ = new int[] {6,5,4,3,2,9,8,7,6,5,4,3,2};
	private static final Integer DIVISOR = 11;
	
	public static boolean ValidCpf(String cpf) {
		if (cpf.length() != 11) {
			return false;
		}
		int cont = 1;
		char[] aux = cpf.toCharArray();
		int J;
		int K;
		int soma = 0;
		for (int i = 0; i <= 8; i++) {
			soma += PESO_CPF[cont] * Integer.parseInt(String.valueOf(aux[i]));
			cont++;
		}
		if (soma % DIVISOR == 1 || soma % DIVISOR == 0) {
			J = 0;
		} else {
			J = DIVISOR - (soma % DIVISOR);
		}

		soma = 0;
		cont = 0;
		for (int i = 0; i <= 9; i++) {
			if (i == 9) {
				soma += J * PESO_CPF[9];
			} else {
				soma += PESO_CPF[i] * Integer.parseInt(String.valueOf(aux[i]));
			}
			cont++;
		}
		if (soma % DIVISOR == 1 || soma % DIVISOR == 0) {
			K = 0;
		} else {
			K = DIVISOR - (soma % DIVISOR);
		}

		if (J == Integer.parseInt(String.valueOf(aux[9])) && K == Integer.parseInt(String.valueOf(aux[10]))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validCnpj(String cnpj) {
		if(cnpj.length() != 14) {
			return false;
		}
		int J;
		int K;
		int soma = 0;
		int cont = 0;
		char[] aux = cnpj.toCharArray();
		for (int i = 1; i <= 12; i++) {
			soma+= Integer.parseInt(String.valueOf(aux[cont]))*PESO_CNPJ[i];
			cont++;
		}
		if(soma%DIVISOR == 0 || soma%DIVISOR == 1) {
			J = 0;
		} else {
			J = DIVISOR-(soma%DIVISOR);
		}
		
		cont = 0;
		soma = 0;
		for (int i = 0; i <= 12; i++) {
			if(i == 12) {
				soma += J * PESO_CNPJ[12];
			} else {
				soma += PESO_CNPJ[i]*Integer.parseInt(String.valueOf(aux[cont]));
			}
			cont++;
		}
		
		if(soma%DIVISOR == 0 || soma%DIVISOR == 1) {
			K = 0;
		} else {
			K = DIVISOR-(soma%DIVISOR);
		}
		
		if(J == Integer.parseInt(String.valueOf(aux[12])) && K == Integer.parseInt(String.valueOf(aux[13]))) {
			return true;
		}else {
			return false;
		}
	}

}
