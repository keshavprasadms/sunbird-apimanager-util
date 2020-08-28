package in.ekstep.am.step;

import in.ekstep.am.builder.RegisterCredentialResponseBuilder;
import in.ekstep.am.dto.credential.RegisterCredentialRequest;
import in.ekstep.am.jwt.KeyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class RegisterPortalCredentialStepChain {

    @Autowired
    private KeyManager keyManager;

    public void execute(String userName, RegisterCredentialRequest request, RegisterCredentialResponseBuilder responseBuilder) throws Exception {
        for (Step step : stepChain(userName, request, responseBuilder)) {
            if (responseBuilder.successful()) {
                step.execute();
            }
        }
    }

    private List<Step> stepChain(String userName, RegisterCredentialRequest request, RegisterCredentialResponseBuilder responseBuilder) {
        SignPortalCredentialWithKeyStep createCredentialWithKeyStep = new SignPortalCredentialWithKeyStep(
                userName, responseBuilder, request.key(), keyManager);
        return asList(createCredentialWithKeyStep);
    }
}