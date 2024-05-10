
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.TarjetaCredito;
import repositories.TarjetaCreditoRepository;

@Service
@Transactional
public class TarjetaCreditoService {

	@Autowired
	private TarjetaCreditoRepository tarjetaCreditoRepository;


	public Collection<TarjetaCredito> findAll() {
		Collection<TarjetaCredito> result;
		result = this.tarjetaCreditoRepository.findAll();
		return result;
	}

	public TarjetaCredito save(final TarjetaCredito tarjetaCredito) {
		Assert.notNull(tarjetaCredito);
		Assert.isTrue(!this.tarjetaCreditoRepository.exists(tarjetaCredito.getId()));

		TarjetaCredito result;

		result = this.tarjetaCreditoRepository.save(tarjetaCredito);

		return result;
	}

	public void delete(final TarjetaCredito tarjetaCredito) {
		Assert.notNull(tarjetaCredito);
		Assert.isTrue(tarjetaCredito.getId() != 0);
		Assert.isTrue(this.tarjetaCreditoRepository.exists(tarjetaCredito.getId()));

		this.tarjetaCreditoRepository.delete(tarjetaCredito);
	}

	public TarjetaCredito findOne(final int tarjetaCreditoId) {
		Assert.isTrue(tarjetaCreditoId != 0);

		TarjetaCredito result;

		result = this.tarjetaCreditoRepository.findOne(tarjetaCreditoId);
		Assert.notNull(result);

		return result;
	}

	public TarjetaCredito findByName(final String titular) {
		Assert.isTrue(titular != "");

		TarjetaCredito result;

		result = this.tarjetaCreditoRepository.findByName(titular);
		Assert.notNull(result);

		return result;
	}
}
