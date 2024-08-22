import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the username or identifier of the current user
        // For example, using a hardcoded value or from the security context
        return Optional.of("system"); // Replace with actual user details
    }
}
