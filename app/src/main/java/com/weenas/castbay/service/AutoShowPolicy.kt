package com.weenas.castbay.service

/** Only bring the app forward for AirPlay image/video, not background music or other protocols. */
internal object AutoShowPolicy {
    fun isAirPlayVideo(state: AirPlayConnectionState, stream: StreamInfo): Boolean =
        state == AirPlayConnectionState.Streaming && !stream.isDlna && !stream.isDesktop &&
            (stream.isMirroring || stream.isVideoPlayback) && !stream.isAudioOnly
}
