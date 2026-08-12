package com.zhitool.rearlyric.rear

import com.zhitool.rearlyric.lyric.LyricSource
import org.junit.Assert.assertEquals
import org.junit.Test

class StaggerPanelLongPressTargetTest {
    @Test
    fun `lyricon uses the clock as the long press target when the clock is visible`() {
        assertEquals(
            StaggerPanelLongPressTarget.CLOCK,
            staggerPanelLongPressTarget(LyricSource.LYRICON, showClock = true),
        )
    }

    @Test
    fun `lyricon disables the panel gesture when the clock is hidden`() {
        assertEquals(
            StaggerPanelLongPressTarget.DISABLED,
            staggerPanelLongPressTarget(LyricSource.LYRICON, showClock = false),
        )
    }

    @Test
    fun `superlyric keeps the existing whole page long press target`() {
        listOf(true, false).forEach { showClock ->
            assertEquals(
                StaggerPanelLongPressTarget.WHOLE_PAGE,
                staggerPanelLongPressTarget(LyricSource.SUPERLYRIC, showClock),
            )
        }
    }
}
