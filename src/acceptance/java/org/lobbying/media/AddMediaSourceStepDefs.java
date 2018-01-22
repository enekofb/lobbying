package org.lobbying.media;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.common.CommonPolicyStepDefs;
import org.lobbying.media.dto.MediaSourceDTO;
import org.lobbying.policy.dto.CreatePolicyDTO;
import org.lobbying.policy.dto.PolicyDTO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddMediaSourceStepDefs extends CommonPolicyStepDefs {

    private MediaSourceDTO mediaSourceDto;

    private MediaSourceDTO addedMediaSource;

    @Given("^I want to add a media source with name \"([^\"]*)\" and url \"([^\"]*)\"$")
    public void iWantToAddAMediaSourceWithNameAndUrl(String mediaSourceName, String mediaSourceUrl) throws Throwable {

        mediaSourceDto = MediaSourceDTO.builder()
                .name(mediaSourceName)
                .url(mediaSourceUrl)
                .build();
        assertThat(mediaSourceDto.getUrl(), equalTo(mediaSourceUrl));
        assertThat(mediaSourceDto.getName(), equalTo(mediaSourceName));
    }

    @When("^I add the media source$")
    public void iAddTheMediaSource() throws Throwable {
        addedMediaSource = mediaSourceClient.postForObject(CREATE_MEDIA_SOURCE_URL,
                mediaSourceDto, MediaSourceDTO.class,port);
        assertThat(addedMediaSource.getName(),equalTo(mediaSourceDto.getName()));
    }

    @Then("^the media source has been added$")
    public void theMediaSourceHasBeenAdded() throws Throwable {
        MediaSourceDTO gottenMediaSource = mediaSourceClient.postForObject(GET_MEDIA_SOURCE_BY_ID_URL,
                mediaSourceDto, MediaSourceDTO.class,port);
        assertThat(addedMediaSource.getId(),equalTo(gottenMediaSource.getId()));
    }
}
