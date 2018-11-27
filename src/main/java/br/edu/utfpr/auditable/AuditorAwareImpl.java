// Nessa classe defino quem foi o responsável por cada entrada no banco.
package br.edu.utfpr.auditable;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Luiz Felipe");
    }

}