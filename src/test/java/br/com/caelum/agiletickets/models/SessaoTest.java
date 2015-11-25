package br.com.caelum.agiletickets.models;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}
	
	@Test
	public void deveVender5ingressosSeHa10vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(5));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void calculaPorcentagemDisponivel() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);
		sessao.setIngressosReservados(4);
		Assert.assertEquals(0.20, sessao.getPorcentagemDisponivel(), 0.001);
	}
	
	@Test
	public void calculaPrecoComTaxa() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setPreco(BigDecimal.valueOf(10.00));
		Assert.assertEquals(new BigDecimal("12.00"), sessao.getPrecoComTaxa(0.2));
	}
	
}
