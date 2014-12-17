struct ad_info {
    1: string os,
    2: string browser,
    3: string region,
    4: i32 hour,
    5: string searchWord
}

service AdServerService{
list<string> ask4Ads(1:ad_info info)
//	list<i32> askIndex4Ads(1:string searchWords)
//	list<i32> askRanking4Ecpm(1:string url)
}