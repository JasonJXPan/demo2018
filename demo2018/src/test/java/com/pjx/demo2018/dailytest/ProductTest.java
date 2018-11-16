package com.pjx.demo2018.dailytest;

import com.google.gson.Gson;
import com.juqitech.service.utils.BigDecimalUtil;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by juqi on 18/11/2.
 */
public class ProductTest {
    @Test
    public void testAB(){
        String values = "22159020633,22122006249,9386138044,21517206271,21517206298,20912406320,20912406342,20183398947,20221206416,20221206439,19702806514,19530006567,19011606609,19011606631,19011606651,19011606673,19011606728,10890006761,18579606783,18579606811,18493206929,5930138109,18320408590,25578008612,25578008634,25578008656,18320408678,17370008749,5411738119,17197208864,16641161592,17197208946,17715609008,17370009061,17283609095,17283609117,15296409154,17283609191,17110809267,14950809302,14950809325,16592409378,16592409401,16592409423,16592409447,16592409473,16592409494,16592409517,16592409538,16592409571,16592409593,16626717078,17024409636,16851609659,16506009685,16160409738,16074009762,16074009785,15382809875,15987609899,15296409921,15901209952,15814809985,15814810018,15555610041,14778010260,14691610427,14691610460,14605210515,14259610610,14086810823,12745471674,12745459784,3517285372,13136411189,13395611359,13136411493,13136411536,13136411562,13222811585,13136411626,13136411669,13136411713,2742803481,12445212013,12358812057,12358812100,12358812122,12358812145,12358812168,12358812192,12358812213,12358812236,12358812258,12358812280,12358812301,218950821,10500012848,10717213237,10630813282,10630813542,10544413565,10198813728,9939613877,1175714762,3076383762,9334814006,123934533,9248414170,8643614218,2817183749,9334814286,8902814347,8902814369,8902814392,8902814467,8902814499,8816414698,8730014899,8557215253,8557215274,8557215295,8557215316,8557215338,8557215360,238025861,8557215411,8557215443,8643615571,1960369670,7064600647,8125216085,8125216117,8125216139,7693216415,7693216436,7693216469,7174816680,7606817013,6111562973,7347617417,7347617439,7347617532,6744313730,7088417640,7088417662,7434017683,131053639,131053643,6483617819,6029762693,5244978954,1610498512,6436807195,6915618281,6224418406,1421799922,6915618767,6742819078,490901479,6483619384,6483619446,6397219598,6397219932,6397219962,6397219983,6397220007,6397220028,6397220050,6397220071,6397220100,6397220125,6397220149,6397220171,6310820204,6310820225,6310820271,6310820294,6310820460,6310820507,6310820530,576653936,6224421096,5619621512,5619621540,5619621562,5619621583,5619621605,5619621626,5619621647,5619621669,5619621712,5619621735,5619621758,5619621780,5642533876,5486335014,5619621824,5619621845,5619621867,5619621889,5619621911,6138021994,6138022016,61346851,307896322,5576702706,6138022087,6138022108,6138022131,6138022175,35153447,35153456,37537765,35153463,6138022281,1255232012,1966770731,4640866580,4640866328,759313893,566084455,5792422988,4377327865,151545183,559948192,5101223791,5101223813,5087107576,5619623988,5619624030,559948198,905816523,140719923,817046090,5706024659,306578809,42711353,5226462066,41411269,66629880,5706024766,4036066730,210479137,556767268,5101225012,1358903299,3949666365,4035448740,324411762,3694120124,4034800147,5134871336,4536416781,4529484134,4496425167,4496425192,4496425215,4496425263,4496425284,3518505446,4496425313,4496425339,3678676791,4496425363,5134874954,3863266387,4928425479,4928425505,3854954522,579238411,4669225606,3517666698,482342503,3431266409,4582825859,4582825882,3522433879,4496426110,403041888,4496426283,2726640907,2393120552,2393120559,3243602056,2393120580,2393198967,2746503222,2805692894,2743991648,3344866434,3842701478,3842750795,3842740792,3842693439,3429208060,3258466605,4410026337,574767002,4410026391,4410026412,4410026434,4410026456,4410026477,4410026497,3956405386,4410026540,3756865087,1436594499,3718826562,3258466456,227587322,1347845881,4357278233,4357281845,4011689409,4015863557,2826466479,4011695107,2768426830,2798009059,2768426878,3891626903,2740066786,3891626946,3929463568,300333468,3891627068,3891627089,3929463577,3891627166,1273494101,1273494103,1273494124,2287201189,1273494134,1354660873,1869045580,2038897573,1790585866,1624817872,3693484195,3412405085,3925298597,3891627229,3891627253,3805227277,1273494135,1273494159,3180604031,3061602263,3335429226,3891627628,3519651917,246959967,2740066629,47486761,3805227785,1270303462,1702015228,3341683456,2143974228,3718827820,2567266504,2547307812,2547298375,2547293197,2990756788,1768757899,2891269203,2768428586,2801442911,3459628642,1697054647,1699305929,1697054651,1273860152,1697054654,1697054730,1697054724,1696700998,1696701011,1696701005,2125712979,1696701025,1771556000,672571311,300503915,2203881735,1622588190,2292701854,1780095980,3632428879,2768428949,2314803487,665751667,2768429040,3787471767,1268652729,1269029161,1269029166,1268652735,2768429091,2682029124,2682029146,1766676122,2215771929,1770185329,2768429211,2204528435,2768429247,2768429268,921327882,2768429298,2768429323,1603910086,2768429384,2768429445,2077229487,2077229512,2077229536,229735118,2682029560,1613667443,2163629647,2208581639,2163629679,2196589344,2163629734,2053244247,2682029778,2682029823,993639567,1244834654,1175008086,2725208414,2204354243,1529973757,1693175345,2682030035,39968986,2389745934,3200430133,1249721423,2389745968,2682030216,1702015236,143392630,2768430310,2768430370,1190971316,2682030422,1098368330,2738827043,2212845007,2134972044,1682352545,2768430678,2768430717,1339496464,1532587794,2312831104,479623313,1767442778,2122049334,2682030913,2682030936,2682030961,2115428849,1268652751,2682031071,2682031092,2682031137,2310057027,1787429172,1512012710,1187094137,2629438925,2595631334,1685433337,1685562848,1684804330,2631906451,930824120,1775087065,1184594011,1017624480,1361965497,1531434963,2509231634,1853657625,2509231666,2040730118,1775953908,1857921890,1610050894,2509232061,1078004648,1702811265,2281833346,1623510959,1860701861,2250032203,1615170380,2284006709,2250032248,1773832280,837920584,2024725593,400691453,63859916,383335253,398382612,398382614,398382614,398382618,398382626,398382657,398382667,582086949,582086954,398382662,582086956,582086966,398382665,398382670,489080176,649046658,1558832304,1190064602,649046662,1558832327,136558163,136558168,1525174673,1558832357,7088432380,1558832413,1558832437,1558832459,1613677959,928359801,1258964382,658693249,2163632552,306068482,306068495,306068514,572320082,572320086,572320098,735872421,572320102,306068524,572320103,573927542,573927547,408536066,572320131,573927551,306068529,408536070,408536082,306068536,1166072955,306068539,408536084,408536086,1166072960,572320135,572320134,306068448,306068453,306068458,306068461,306068491,306068470,306068494,470854829,306068490,306068499,306068504,306068509,306068519,839243503,567218840,306068479,2163632607,2595632629,1361078111,1873268909,1606055493,1269560021,1080004497,1269560040,906619784,2077232695,1708324151,1182629198,914420212,306068566,909907286,1784945997,1694613382,2203968796,1161862008,1185705455,2192440850,573927558,1079672994,408536090,1528770388,665120576,665120573,322136095,1274678112,814117908,1444826126,1179505540,2117503065,2163633011,2163633037,2163633059,582086966,1602006353,572320128,1166072998,1185705455,573927565,1607890903,1685954249,757660755,1531226135,1422778411,404352748,921080177,1522119206,997003326,1528335578,1608213387,485920143,1599554250,1533050177,1702133732,1599554253,219668577,1179505547,42322996,995763757,1079673004,2077233332,835716811,489080181,2077233359,1533383426,1262859757,219668582,931276231,2023835752,1432802449,1188891376,901752321,2025475202,1513154272,919249588,1523901052,219668607,2163633532,931984419,1990833565,1692408737,758911509,61560209,921211388,904739072,921211383,834425252,934522458,400691460,499682764,1990833618,495792437,1014859804,124866581,1425075621,322136100,759474246,731593028,1525746025,929435087,1904433651,1612163456,1904433685,495894139,1079673007,485920127,408536099,1525746052,645859044,413371321,1861209379,924067234,832849577,1358658219,1593863974,664962610,910739472,61560208,1010125753,485920388,1342804024,848122462,672028033,61560217,743310051,839226370,645583903,2077233819,636487593,1904433842,1425607519,222251174,125903794,222251188,222251183,222251180,222251179,222251172,232163821,232132220,232152873,232142544,232173851,232184478,125919154,650707295,1645233890,1252805633,237902523,1256402749,1299633922,241551178,298196093,322711458,154171332,562234127,480818847,643904217,233120576,210462832,412247060,1645234015,1095268418,1009782882,993601980,1645234038,1257946922,757218028,648327607,648327608,757218032,1645234086,219402742,993605202,1093575926,154512267,389568650,389568651,389568657,1645234109,398687296,150542723,643904228,471120166,1085909963,219668627,1000276174,151567369,645554207,1274336178,1172328935,219668585,147310984,497102363,1558834288,1558834340,1013058220,647102024,478121585,475834132,1169501862,472684030,326911508,1089813406,491131805,664229188,1558834395,60171503,147310998,392796924,923970396,222251196,954034483,954034505,989263115,1015721764,579939271,579939277,579939284,579939289,918536881,579939292,579939317,68112275,579939459,580235850,579939462,1096434196,1161209221,907212868,920093550,842783219,396474515,396474519,1099195241,1000803505,579939459,1161051058,918536888,915146609,579939461,1161088937,580721384,579939462,1096087056,990566777,579939460,992109549,579939485,916400697,396474529,579939482,579939340,915338367,918536948,579939350,579939348,580221325,580637436,579939571,581034969,560795298,1087757158,572673444,907208708,729306036,909020807,1592468283,302342931,46817061,923970397,663852755,221119584,664229217,1597385530,147311000,1006140231,561429647,64926249,1579005175,150294184,997164979,385993033,1596729431,995185679,39144257,498909270,819191457,1429209813,39144255,493539382,493539570,560735458,60911002,471065937,471080450,1253253190,1472434793,493539572,1253253196,389434137,1472434827,60911024,560795299,147311028,312308398,555496361,500751186,1180072370,814604566,1771493792,401072785,1558834892,997205675,1008721609,1558834914,1168821233,496367102,931984419,147311035,583846581,213237882,581586383,579939574,305107302,1000805249,1515605779,1260682825,65387507,324824699,1184008166,915697600,954035037,579939575,997211553,147311037,563072429,1092891697,60911018,1003659761,41603850,928569830,474395297,46602740,221933552,316280183,924009446,1509691946,39144258,496980312,219636221,39144286,216371984,227096607,494849429,1472435112,208996753,325321715,739168164,137686822,557504229,664229202,1160712806,663852773,1558835155,1008877965,300517003,574866589,306608753,669118488,301973759,147311040,654935202,1558835187,1586430484,128699442,384858963,224651810,1339653205,139132081,413874251,1094474384,1091130256,1099195252,1558835242,922000267,1594732693,1558835284,486747203,583846655,485982752,138251815,239935289,1344374874,395556830,837570404,837570431,60911043,471655942,1010034206,498058173,1472435376,60911047,910807078,327474254,1472435437,560764588,317666524,72271769,212693566,991338572,71269602,71269595,1165079180,223994919,580043507,493539383,827590262,837570434,404731808,241206559,418374052,387622041,404251721,402260844,133686924,321382116,555921806,402260848,492409311,402260850,219728820,404251725,324377534,321554917,133686923,299747052,44480297,493183610,321207935,469019310,469134777,321065877,469238668,402260858,469882531,496848802,470135023,404251729,133686923,415678194,414848109,402260864,404251734,404251742,404251766,133686909,298786577,301104963,301919218,402260865,478043984,414848114,404251761,240502902,402260869,133686947,402260874,321132622,402260879,402260912,402260917,402260922,133686946,133686950,298680638,414848125,402261091,475045974,402261092,413379399,414848125,413379399,298587048,494317107,402261091,402261092,402261094,414848131,495000861,219728819,402259123,410584864,404251767,402261096,402261097,414848162,492327614,474089435,476248812,476325611,400682929,476293420,414848164,404251766,404487842,402261097,404251757,404251779,404251904,493535078,402260944,321084567,402260944,414848143,414848173,402260951,301104984,414848159,209947123,409886798,324377587,492253035,492085427,498257739,407164383,44480305,298852821,414848186,402260958,299148693,470055351,402260965,402260976,44480313,473948678,129990591,470293716,321832413,1010034210,1105900949,1015112490,406083311,1093221111,1095054204,820804756,225667406,1089723102,910802655,1089723101,225667410,930211799,932307923,935636565,929891074,910807235,1108953943,1017103209,838972063,1429205156,1015145926,751298286,1017103209,1095054204,1093221111,408917505,1003418395,308018849,1503362678,42299449,316280188,1472435570,476672430,46868627,321294002,227096611,138251823,230916813,404731804,389711298,389711479,1098377926,485757821,910802541,994754280,1472435647,579847730,327474257,325588951,1105900949,1003250764,213583907,472266645,924547522,397099561,827720688,921534178,325481590,820808839,1013131162,827487332,58621702,502980983,393058679,224178880,1097695123,923131437,392474281,1091130264,500665210,138251820,1003601218,489445600,240511511,60911057,1167358727,235073696,1386035681,237170025,836077985,488305550,237459171,321459805,151017188,127770056,146562626,239260516,68415162,132307307,923634228,141653539,237459173,323940441,488305556,233521145,1386035713,60867042,221618856,218699061,154111513,215693678,404808043,228327568,140470783,38922352,226720395,384704234,38922358,226817032,411046663,824406918,60867049,62061531,412464032,1386035780,734412551,120522156,120522160,120522191,904769176,139182678,308664827,314518225,734411465,149648791,316465660,138987247,139251713,141790696,140635586,140918521,139149567,139756831,211463700,218101683,139149567,140918521,139251713,138987247,152821682,235491804,130488870,238424730,238370035,474026137,247867136,142424931,149291918,142424957,149286735,227975745,227975745,38422961,314849151,232913958,237459168,230940776,233727037,142424931,142424929,142424934,142424935,327626563,227975743,227812534,142424855,305086754,237459164,331689458,232818186,142424933,238476339,299705300,303884563,304740558,217898603,394099140,319683304,227975755,142424953,229339880,227975751,142424850,398396336,482077369,150361950,50995587,1558835803,1386035824,1386035844,1386035865,1386035899,62936130,130902271,491553139,312554535,228579938,318331807,909636839,147388828,1386035920,924860948,299404891,132307339,1342805190,1420871348,226068861,1342805190,1019500952,211173143,136277389,1003323103,491052977,154111515,1342807019,382917753,135067736,226720393,1386036004,847413906,299404895,836077976,1386036045,327626568,129630365,228327576,924860948,385005636,299404897,378134076,1386036067,327918676,1099479062,997702652,128098786,824403971,1386036091,1019500955,834035480,1019500965,318230252,212676055,123346253,213536460,916457314,134348095,318331817,311378867,152003942,151652521,1299636247,1299636269,667226141,37243677,299459725,243322468,38509330,131701696,838460951,1299636331,218051669,298605645,754412547,1006509020,236300721,140320395,231931838,131701694,42198622,138200452,41059046,848864120,152966982,65603950,836685339,218686757,240053765,152189787,37735268,128779638,142671841,750663091,139078027,329528947,152983799,405016346,128779641,741602246,909313844,54296615,1299636374,307702422,753858419,1335505283,54296624,216634145,146418192,322049434,211506351,41059051,142595997,313473447,395677427,236486970,231931834,311569992,903797552,55348082,579071601,1256402655,36946255,40578432,40014743,60384812,124205542,54919285,39893568,670089279,820803936,656437268,656490245,236528665,226297097,52782656,751731078,315666592,664770438,66942725,128779644,313485889,63961952,141927583,225275930,41059060,142726437,494010121,402253294,1299636528,213305300,54296627,1299636550,405695563,60162630,839995257,34195762,59946575,298304240,235856584,48667744,231931829,52782663,1299636572,231931826,237902371,131392703,1299636604,237902523,213004923,52782666,131701704,41059061,664770442,65603923,59930259,65603927,303472447,242805994,151546759,65603937,391184950,296812628,391184978,65603936,59930266,391184961,59930272,129307811,319060994,139078010,146241281,325327545,139078017,139078026,391184979,129307832,65603978,65603979,129307839,398555641,47662818,237201833,838104531,224728424,140656043,751912454,139964451,750291282,1007338601,1299637183,1339190803,51757141,131701747,144850493,56360452,146413647,218310626,41062352,231821151,58116822,67711523,42324675,762489898,222117060,301595299,38773272,480356420,54923600,63130167,405570426,67318770,45116960,478806813,388808067,125445103,63665876,570986163,656692754,1040437631,405570456,37075532,54923593,55240009,1071465554,478805297,833747204,240241953,39405657,408026150,39405647,391025148,39032372,478804727,1040437724,476681787,56589818,316326209,405570441,563544154,405570639,54273472,39032374,319871607,49936965,652102660,65435093,140091812,1023879490,70617616,128702049,128702041,1000806289,997203713,482402751,1040437985,1040438026,1074659774,734924934,138055921,137856145,1019314911,1040438049,653146927,735756367,482401935,65321677,65321683,388802819,388808066,405570639,752561269,138272664,585446615,1040438081,51107650,60426341,1040438102,1040438123,563903626,502812876,55307503,39032378,37259208,405570640,502015380,62849444,54273481,1014635413,476486670,43201086,1040438174,405570649,568539786,140825175,48502428,145326139,140825250,54285893,481589762,63130169,319871630,227445742,405570669,227445761,482130878,482144851,482405887,400136890,478802722,482405549,482402126,400136922,482402056,400136950,1040438207,1074024764,477875704,395593313,225321808,2570570059,2570570063,2545476108,2831670142,657093205,671674472,56653306,739501250,56653315,62645395,954038399,733425612,413092522,914001103,655608795,475205722,408042710,44597821,407686684,319170642,926707211,477891066,56653316,954038449,926707215,471919647,141045917,141045786,566746964,476095085,59553128,40892291,392410504,954038513,500403282,319170672,556902696,323507604,64388265,562883834,402035505,748316440,486589120,985574440,926707220,310897610,910815029,54838987,587500999,396006642,398484468,581291969,499984423,488058731,484729922,392412124,954038664,56653325,66493660,396003675,41785761,954038695,404499951,124750059,954038759,987269526,313736954,318373171,831804225,313736952,399781427,559081527,313748329,954038961,409593160,141968332,233471636,571778881,396004041,954039003,991875940,475203559,403118858,236688525,39160803,56653329,831804228,491549940,231156434,44246657,319492732,646968316,954039091,33344491,587500994,320572079,42364593,572204649,318645228,61694145,954039158,49233358,318384488,313736966,386767414,42302033,316069540,986907101,128675887,128411491,926707225,380433859,66493673,976669227,127022350,986262829,564315713,60580865,492860969,587500980,48276216,63692081,954039560,47725000,44246705,593171171,44807563,233471653,396005032,416945759,571846366,49233372,954039601,318421056,145023320,992213851,396001869,304488253,990995209,302891433,310970785,925201973,404077983,914403758,475202675,50077362,39745434,1126839674,954039696,954039716,497025868,472205992,56653348,302410537,392414815,474841805,302114767,483221234,392407338,60174247,239087028,239087038,392406642,572204629,37201140,42124351,1531432408,2374742976,1865208734,4892825044,4201625055,4115225086,3683225332,3596825103,3510425191,3078425166,2819225165,4892825045,3510425088,2992025176,3769625092,4288025063,4928440776,2992025166,2854840797,38612168,302408597,313873824,3867545052,2205479101,1171054979,1860701876,1183160038,1183160049,2768468573,2768468598,2163668620,1904468641,1526325170,991052931";
        String[] split = values.split(",");
        for (String x : split) {
            testOldRule(x);
        }
    }
    public static   void testOldRule(String x){
//        String x = "{    \"compensate_id\": \"5bad99028e8efd5e3d92abc0\",    \"compensate_type\": \"overdue\",    \"overdue_time_gap\": 1273860152  }";
//        Gson gson = new Gson();
//        MyObject myObject = gson.fromJson(x, MyObject.class);

        final long DAY = 24 * 60 * 60 * 1000;
        long cicle = 5 * 1 * DAY;
        long overdueGap = Long.parseLong(x);
//        System.out.println(overdueGap/DAY);
        BigDecimal baseCompensate = new BigDecimal(50);
        overdueGap = overdueGap - cicle;
        BigDecimal extendCompensate = BigDecimal.ZERO;
        if (overdueGap > 0) {
            long cicleCount = overdueGap / DAY;
            if (overdueGap % DAY > 0) {
                cicleCount += 1;
            }
            int extendLimit = 30 - 5;
            if (cicleCount > extendLimit) {
                cicleCount = extendLimit;
            }
            extendCompensate = BigDecimalUtil.mul(5, cicleCount);
        }
        BigDecimal compensate = BigDecimalUtil.add(baseCompensate, extendCompensate);
        System.out.println(compensate);
//        System.out.println("update tm_order_compensate t set t.amount="+compensate.doubleValue()+" where t.compensate_id='"+myObject.getCompensate_id()+"';");
    }
}
