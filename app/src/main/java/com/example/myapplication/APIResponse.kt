package com.example.myapplication

data class APIResponse(
    val data : Data,
    val meta: Meta
)

data class Data(
    val articles: Articles
)

data class Meta(
    val brand: String,
    val description: String,
    val message: String,
    val status_code: Int
)

data class Articles(
    val Response: List<Response>,
    val Status: Boolean
)

data class Response(
    val ArticleId: String,
    val ArticleSourceId: String,
    val ArticleSourceInfo: List<ArticleSourceInfo>,
    val ArticleSourceType: String,
    val ArticleType: String,
    val CanUserWriteComments: Boolean,
    val CategoryId: String,
    val CategoryName: String,
    val CreatedDate: String,
    val CreatedDateInt: Int,
    val CreatedDateReal: String,
    val Description: String,
    val DetailCounterScript: Any,
    val External: String,
    val HideArticleRightColumn: Boolean,
    val ListCounterScript: Any,
    val ModifiedDate: String,
    val NameForUrl: String,
    val NameForUrl2: String,
    val QuickImageType: Int,
    val SortOrderCurrent: Int,
    val Source: String,
    val Spot: String,
    val SpotShort: String,
    val SurmansetBaslik: Boolean,
    val SurmansetBaslikKategori: Boolean,
    val Title: String,
    val TitleShort: String,
    val Url: String,
    val UsedMethod: Boolean,
    val primaryImage: String,
    val primaryImageAlternateText: String,
    val secondaryImage: String,
    val secondaryImageAlternateText: String
)

data class ArticleSourceInfo(
    val Id: String,
    val Source: String,
    val Type: String,
    val primaryImage: String
)
