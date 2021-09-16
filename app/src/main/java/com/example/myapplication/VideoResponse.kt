package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("data")
    val data: DataResponse,
    @SerializedName("Meta")
    val meta: MetaResponse
)

data class DataResponse(
    val videos: Videos
)

data class MetaResponse(
    val brand: String,
    val description: String,
    val message: String,
    val status_code: Int
)

data class Videos(
    @SerializedName("Response")
    val ResponsedVideo: List<ResponsedVideo>,
    val Status: Boolean
)

data class ResponsedVideo(
    val BroadcastKind: String,
    val CategoryId: String,
    val CategoryName: String,
    val CreatedDateReal: String,
    val Description: String,
    val Episode: Any,
    val Id: String,
    val ModifiedDate: String,
    val ReferenceSiteId: String,
    val Season: Any,
    val SortOrderCurrent: Any,
    val Spot: String,
    val SpotShort: String,
    val TitleShort: String,
    val Url: String,
    val VideoDuration: String,
    val VideoMobileUrl: Any,
    val VideoSmilUrl: String,
    val VideoTypeId: Int,
    val VideoUrl: String,
    val WebSiteId: String,
    val primaryImage: String
)