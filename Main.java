public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * A VALIDAÇÃO QUE É FEITA NESSE CÓDIGO, É APENAS PARA VALIDAR OS DIGITOS VERIFICADORES DO CPF
		 * CPF's COM NÚMEROS REPETIDOS (111.111.111-11, 222.222.222-22) SÃO INVÁLIDOS, PORÉM PASSAM NESSA VALIDAÇÃO
		 * */
		
		if( validaCPF( "06119597476" ) )
			System.out.println( "CPF válido" );
		else
			System.out.println( "CPF inválido" );
		
	}
	
	public static boolean validaCPF( String cpf )
	{		
		List<String> listaCPF = new ArrayList<String>();
		
		int mod, pos, res, verificador;
		int total = 0;
		int seq = 10;
		int controle = 0;
		
		for ( int i = 0; i < 11; i++ )  //ADICIONA CADA DIGITO DO CPF EM UMA POSIÇÃO DA LISTA
			listaCPF.add( String.valueOf( cpf.charAt( i ) ) );
	
		for ( int cont = 0; cont <= 1; cont ++ )  //VAI REPETIR 2 VEZES PARA VALIDAR O 1º E 2º DV
		{
			int x = cont + 9;
			do 
			{				
				//NA 1º PASSAGEM VAI PERCORRER OS 9 PRIMEIROS DIGITOS
				//NA 2º, VAI PERCORRER OS 10 PRIMEIROS
				for ( int i = 0; i < x; i ++ )
				{
					pos = Integer.parseInt( listaCPF.get( i ) );
					total += pos * seq;
					seq -= 1;
				}
				
				mod = total % 11;
				res = 11 - mod;
				
				if ( res >= 10 )
					verificador = 0;
				else
					verificador = res;
				
				//1º PASSAGEM VERIFICA COM O 1ºDV (OCUPA A POSIÇÃO 9 NA LISTA)
				//2º PASSAGEM VERIFICA COM O 2ºDV (OCUPA A POSIÇÃO 10 NA LISTA)
				if ( verificador == Integer.parseInt( listaCPF.get( x ) ) )
				{
					if ( cont == 1 )  //SE FOR = 1, TA VERIFICANDO O 2º DIGITO
						return true;
				}
				else
					return false;
				
				controle += 1;
			} while ( controle == 0 );
			
			//PARA VERIFICAR O 2ºDV, É FEITA A MULTIPLICAÇÃO DOS 10 PRIMEIROS DIGITOS PELA ORDEM DECRESCENTE DE 11 A 2
			seq = 11;
			total = 0;
		}
		return false;
	}
}
