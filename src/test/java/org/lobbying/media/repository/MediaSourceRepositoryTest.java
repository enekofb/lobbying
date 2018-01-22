package org.lobbying.media.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lobbying.PolicyApplication;
import org.lobbying.media.domain.MediaSource;
import org.lobbying.media.dto.MediaSourceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@ContextConfiguration(classes={PolicyApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MediaSourceRepositoryTest {

    @Autowired
    private MediaSourceRepository mediaSourceRepository;

    @Test
    public void canCreateMediaSource(){

        String mediaSourceName = "mediaSource1";

        MediaSource mediaSource = MediaSource.builder()
                .name(mediaSourceName)
                .build();

        MediaSource savedMediaSource = mediaSourceRepository.save(mediaSource);

        assertThat(savedMediaSource.getId(),is(notNullValue()));
        assertThat(savedMediaSource.getName(),equalTo(mediaSourceName));

    }

    @Test
    public void canReadMediaSourceById(){

        String mediaSourceName = "mediaSource1";

        MediaSource mediaSource = MediaSource.builder()
                .name(mediaSourceName)
                .build();

        MediaSource savedMediaSource = mediaSourceRepository.save(mediaSource);

        assertThat(savedMediaSource.getId(),is(notNullValue()));
        assertThat(savedMediaSource.getName(),equalTo(mediaSourceName));

        MediaSource readMediaSource = mediaSourceRepository.findOne(mediaSource.getId());
        assertThat(savedMediaSource.getId(),equalTo(readMediaSource.getId()));
    }



}