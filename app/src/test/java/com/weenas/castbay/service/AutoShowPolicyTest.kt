package com.weenas.castbay.service

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AutoShowPolicyTest {
    @Test fun acceptsOnlyActiveAirPlayVideo() {
        val playing = AirPlayConnectionState.Streaming
        assertTrue(AutoShowPolicy.isAirPlayVideo(playing, StreamInfo(isMirroring = true)))
        assertTrue(AutoShowPolicy.isAirPlayVideo(playing, StreamInfo(isVideoPlayback = true)))
        assertFalse(AutoShowPolicy.isAirPlayVideo(playing, StreamInfo(isAudioOnly = true)))
        assertFalse(AutoShowPolicy.isAirPlayVideo(playing, StreamInfo(isMirroring = true, isDesktop = true)))
        assertFalse(AutoShowPolicy.isAirPlayVideo(playing, StreamInfo(isVideoPlayback = true, isDlna = true)))
        assertFalse(AutoShowPolicy.isAirPlayVideo(AirPlayConnectionState.Connecting, StreamInfo(isMirroring = true)))
    }
}
