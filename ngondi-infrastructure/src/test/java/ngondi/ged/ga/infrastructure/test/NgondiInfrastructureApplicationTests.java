package ngondi.ged.ga.infrastructure.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NgondiInfrastructureApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1() {

	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}

	@Test
	public void tesT4() {
		String matrix19 = "";

		for (int i = 1; i < 10; i++) {

			matrix19 = matrix19 + i;
		}

		System.out.println("Matrice 1 ligne 9 colonne");
		System.out.println(matrix19);

		String matrix99 = "";

		for (int i = 1; i < 10; i++) {

			String ligne = "";

			for (int j = 1; j < 10; j++) {
				ligne = ligne + j;
			}

			matrix99 = matrix99 + "\n" + ligne;
		}

		System.out.println("\n\n Matrice 9 ligne 9 colonne");

		System.out.println(matrix99);

		String matriTriangulaire = "";

		for (int i = 1; i < 10; i++) {

			String ligne = "";

			for (int j = 1; j < i + 1; j++) {
				ligne = ligne + j;
			}

			matriTriangulaire = matriTriangulaire + "\n" + ligne;
		}

		System.out.println("\n\n Matrice 9 ligne 9 colonne triangulaire");

		System.out.println(matriTriangulaire);

		String pyramide = "";

		for (int i = 10; i > 0; i--) {

			String ligne = "";

			for (int j = 1; j < i; j++) {
				ligne = ligne + " " + j;
			}

			pyramide = addspace(10 - i) + ligne + "\n" + pyramide;
		}

		System.out.println("\n\n Matrice pyramide");

		// System.out.println(pyramide);

		for (int i = 1; i < 10; i++) {
			System.out.print(addspace(10 - i));
			for (int j = 1; j < i; j++) {
				System.out.print(" " + j);
			}

			System.out.println("");
		}

	}

	String addspace(int i) {
		String space = "";
		for (int j = 0; j < i; j++) {

			space = space + " ";
		}

		return space;

	}

	@Test
	public void test5() {

		int[] ints = { 9, 2, 3, 1 };
		int plusgrand = plusgrand(ints);
		System.out.println("Lavaleur du plus grand est : " + plusgrand);
	}

	public int plusgrand(int[] ints) {

		int p = ints[0];
		int n = ints[0];
		if (ints == null) {

			return 0;

		} else {

			for (int i = 0; i < ints.length; i++) {

				if (p < ints[i] && ints[i] >= 0) {
					p = ints[i];
				}
			}

			for (int i = 0; i < ints.length; i++) {

				if (n < ints[i] && ints[i] < 0) {
					n = ints[i];
				}
			}

			if (p + n == 0) {
				return p;
			} else if (n < 0 && -n < p) {
				return n;
			} else {
				return p;
			}

		}
	}

	/**
	 * CHERCHE MOT A L'ENVERS
	 */
	@Test
	public void palinfrome() {

		String mot = "pato";
		String motAlenVerre = "";

		for (int i = mot.length() - 1; i >= 0; i--) {

			motAlenVerre = motAlenVerre + mot.charAt(i);

		}
		String[] a = { "a", "b" };
		String c = "";

		for (int i = 0; i >= a.length; i++) {

			c = c + a[i];
		}

		System.out.println("mot à l'envers" + c);
	}

	@Test
	public void getStringFromFile() throws Exception {

		FileInputStream f = new FileInputStream(new File("src/test/resources/test.txt"));

		int l;
		StringBuffer result = new StringBuffer();
		while ((l = f.read()) != -1) {
			result = result.append((char) l);
		}

		System.out.println(result);

		FileWriter fi = new FileWriter(new File("src/test/resources/test.txt"));
		result.append("phrase ajouter");
		fi.write(result.toString());

		fi.close();

	}

	public int[][] getTimesTable() throws Exception {
		/*----------NE MODIFIEZ PAS LE CODE AU DESSUS DE CETTE LIGNE, IL SERA REINITIALISE LORS DE l'EXECUTION----------*/

		/**** Entrez votre code ici ****/

		/*----------NE MODIFIEZ PAS LE CODE EN DESSOUS DE CETTE LIGNE, IL SERA REINITIALISE LORS DE l'EXECUTION----------*/

		int timestable[][] = new int[12][12];

		for (int i = 0; i <= 11; i++) {

			int[] colonne = new int[12];
			for (int j = 0; j <= 11; j++) {

				Array.set(colonne, j, (i + 1) * (j + 1));
			}

			Array.set(timestable, i, colonne);
		}

		String a = "papa";
		a.concat("pp");
		return timestable;
	}

	@Test
	public void test() throws Exception {
		int timestable[][] = this.getTimesTable();

		System.out.println("Le tableau timestamble est :" + timestable[10][5]);
	}
}
