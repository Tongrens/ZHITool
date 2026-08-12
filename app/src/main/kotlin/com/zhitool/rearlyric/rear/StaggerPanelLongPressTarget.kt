/*
 * This file is part of ZHITool — licensed under GPL-3.0 (see LICENSE).
 * Copyright (C) 2026 ZHITool authors.
 */
package com.zhitool.rearlyric.rear

import com.zhitool.rearlyric.lyric.LyricSource

/** 错位交替歌词页在收起态允许从哪里长按打开控制页。 */
internal enum class StaggerPanelLongPressTarget {
    WHOLE_PAGE,
    CLOCK,
    DISABLED,
}

/**
 * 词幕错位交替仅允许长按可见时钟，避免整页长按误触；隐藏时钟即同时关闭入口。
 * SuperLyric 保留原有的整页长按行为。
 */
internal fun staggerPanelLongPressTarget(
    lyricSource: LyricSource,
    showClock: Boolean,
): StaggerPanelLongPressTarget = when (lyricSource) {
    LyricSource.LYRICON -> if (showClock) {
        StaggerPanelLongPressTarget.CLOCK
    } else {
        StaggerPanelLongPressTarget.DISABLED
    }
    LyricSource.SUPERLYRIC -> StaggerPanelLongPressTarget.WHOLE_PAGE
}
