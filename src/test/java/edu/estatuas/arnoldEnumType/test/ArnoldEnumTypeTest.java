package edu.estatuas.arnoldEnumType.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class ArnoldEnumTypeTest {

    public static String[] planetas;

    @BeforeClass
	public static void CreacionArrayPlanetasSetup() {
		planetas = new String[8];
		int planetasIncluidos = 0;
		for (Planeta planeta : Planeta.values()) {
			planetas[planeta.ordinal()] = planeta.name();
			planetasIncluidos += 1;
		}
		assertThat(planetasIncluidos).isEqualTo(Planeta.values().length);
		assertThat(planetas).doesNotContainNull();
	}

	@Test
	public void PlanetaConstructorTest() {
		// me aseguro de que los metodos de la api
		// de los Enum Types se comportan como espero
		Planeta planeta = Planeta.MERCURY;
		assertThat(planeta).isInstanceOf(Planeta.class);
		assertThat(planeta.ordinal()).isZero();
		assertThat(planeta.name()).isEqualToIgnoringCase("MERCURY");
		assertThat(Planeta.valueOf(planeta.name())).isEqualTo(Planeta.MERCURY);
		assertThat(planeta.compareTo(Planeta.MERCURY)).isZero();
		assertThat(planeta.toString()).isEqualToIgnoringCase("MERCURY");
		assertThat(planeta.equals(Planeta.MERCURY)).isTrue();
		assertThat(Planeta.values()[0]).isEqualTo(planeta);
	}
}
