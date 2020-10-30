package mmovie.projcet.dbinit;


import lombok.RequiredArgsConstructor;
import mmovie.projcet.domain.Movie;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieInitDb {

    private final InitService initService;

    @PostConstruct
    public void initDb() {
        initService.dbInit1();
    }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {


        private final EntityManager em;

        public void dbInit1() {
            Movie movie1 = creatMovie("어벤져스 - 엔드게임", "2019.04.24", "안소니 루소, 조 루소", 181,
                    "SF", 9.49, "https://movie-phinf.pstatic.net/20190417_250/1555465284425i6WQE_JPEG/movie_image.jpg",
                    "인피니티 워 이후 절반만 살아남은 지구 마지막 희망이 된 어벤져스 먼저 떠난 그들을 위해 모든 것을 걸었다! 위대한 어벤져스 운명을 바꿀 최후의 전쟁이 펼쳐진다!"
                    , "로버트 다우니 주니어, 크리스 에반스,크리스 헴스워스, 스칼렛 요한슨, 마크 러팔로 ");
            em.persist(movie1);

            Movie movie2 = creatMovie("해리포터 - 아즈카반의 죄수", "2004.07.16", "알폰소 쿠아론", 141,
                    "판타지, 가족, 모험, 액션", 8.72, "https://movie-phinf.pstatic.net/20200214_237/1581663194489UtDmT_JPEG/movie_image.jpg",
                    "시리우스 블랙과의 불가피한 대결은 다가오고, 해리는 자신과 시리우스 블랙 사이에 얽혀있는 엄청난 비밀을 직면하게 되는데"
                    ,"다니엘 래드클리프, 엠마 왓슨, 루퍼트 그린트, 로비 콜트레인, 티모시 스폴");
            em.persist(movie2);

            Movie movie3 = creatMovie("센과 치히로의 행방불명", "2002.06.28", "미야자키 하야오", 126,
                    "니메이션, 판타지, 모험, 가족", 9.58, "https://movie-phinf.pstatic.net/20150113_96/1421113909808LPjqA_JPEG/movie_image.jpg",
                    "금지된 세계의 문이 열렸다! 이사 가던 날, 수상한 터널을 지나자 인간에게는 금지된 신들의 세계로 오게 된 치히로.. 신들의 음식을 먹은 치히로의 부모님은 돼지로 변해버린다. “걱정마, 내가 꼭 구해줄게…”"
                    , "히이라기 루미, 이리노 미유, 나츠키 마리, 나이토 타카시, 사와구치 야스코");
            em.persist(movie3);

            Movie movie4 = creatMovie("맘마미아!", "2008.09.03", "필리다 로이드", 108,
                    "코미디, 뮤지컬, 멜로/로맨스", 8.43, "https://movie-phinf.pstatic.net/20111223_116/1324568059929F372p_JPEG/movie_image.jpg",
                    "우연히 엄마의 일기장을 발견한 소피는 아빠로 추정되는 세 남자의 이름을 찾게 되고 엄마의 이름으로 그들을 초대한다. 결혼식 전날, 소피가 초대한 세 남자(샘,해리, 빌)가 그리스 섬에 도착하면서 도나는 당황하게 되는데... "
                    , "메릴 스트립, 아만다 사이프리드, 줄리 윌터스, 크리스틴 바란스키, 피어스 브로스넌");
            em.persist(movie4);

            Movie movie5 = creatMovie("알라딘", "2019.05.23", "가이 리치", 128,
                    "모험, 가족, 판타지, 뮤지컬, 멜로/로맨스", 9.49, "https://movie-phinf.pstatic.net/20190417_250/1555465284425i6WQE_JPEG/movie_image.jpg",
                    "머나먼 사막 속 신비의 아그라바 왕국의 시대. 좀도둑 ‘알라딘’은 마법사 ‘자파’의 의뢰로 마법 램프를 찾아 나섰다가 주인에게 세 가지 소원을 들어주는 지니를 만나게 되고…"
                    , "메나 마수드, 윌 스미스, 나오미 스콧, 마르완 켄자리, 네이비드 네가반");
            em.persist(movie5);

            Movie movie6 = creatMovie("메기", "2019.09.26", "이옥섭", 89,
                    "드라마, 미스터리, 코미디",  8.78, "\"https://movie-phinf.pstatic.net/20190903_89/1567472276429VUl4Y_JPEG/movie_image.jpg",
                    "오늘은 민망한 엑스레이 사진 한 장으로 병원이 발칵 뒤집혔어요! 세상에! 저를 가장 좋아하는 간호사 윤영 씨는 소문의 주인공이 자신과 남자친구일지도 모른다고 의심하고 있어요."
                    , "이주영, 문소리, 구교환, 천우희, 박경혜");
            em.persist(movie6);

            Movie movie7 = creatMovie("소공녀", "2018.03.22", "전고운", 106,
                    "멜로/로맨스, 드라마", 9.20, "https://movie-phinf.pstatic.net/20180306_274/1520300631041QOrJ2_JPEG/movie_image.jpg",
                    "좋아하는 것들이 비싸지는 세상에서 포기한 건 단 하나, 바로 ‘집’. 집만 없을 뿐 일도 사랑도 자신만의 방식대로 살아가는 사랑스러운 현대판 소공녀 ‘미소’의 도시 하루살이가 시작된다!"
                    , "이솜, 안재홍, 강진아, 김국희, 이성욱");
            em.persist(movie7);

            Movie movie8 = creatMovie("플로리다 프로젝트", "2018.03.07", "션 베이커", 111,
                    "드라마", 8.92, "https://movie-phinf.pstatic.net/20180130_229/1517276941579AqYLj_JPEG/movie_image.jpg",
                    "2018년 우리를 행복하게 할 가장 사랑스러운 걸작! “안심하세요 나랑 있으면 안전해요” 플로리다 디즈니월드 건너편 ‘매직 캐슬’에 사는 귀여운 6살 꼬마 ‘무니’와 친구들의 디즈니월드 보다 신나는 무지개 어드벤처!"
                    , " 윌렘 대포, 브루클린 프린스, 브리아 비나이트, 크리스토퍼 리베라, 발레리아 코토");
            em.persist(movie8);

            Movie movie9 = creatMovie("친절한 금자씨", "2005.07.29", "박찬욱", 112,
                    "모험, 액션, 드라마",  8.77, "https://movie-phinf.pstatic.net/20170904_126/1504516484057JACUa_JPEG/movie_image.jpg",
                    "출소하는 순간, 금자는 그 동안 자신이 치밀하게 준비해온 복수 계획을 펼쳐 보인다. 그녀가 복수하려는 인물은 자신을 죄인으로 만든 백선생(최민식). 교도소 생활 동안 그녀가 친절을 베풀며 도왔던 동료들은 이제 다양한 방법으로 금자의 복수를 돕는다."
                    , "틸다 스윈튼, 폴 다노, 안서현, 변희봉,스티븐 연");
            em.persist(movie9);

            Movie movie10 = creatMovie("옥자", "2017.06.29", "봉준호", 120,
                    "모험, 액션, 드라마", 8.77, "https://movie-phinf.pstatic.net/20170904_126/1504516484057JACUa_JPEG/movie_image.jpg",
                    "자연 속에서 평화롭게 지내던 어느 날, 글로벌 기업 ‘미란도’가 나타나 갑자기 옥자를 뉴욕으로 끌고가고, 할아버지(변희봉)의 만류에도 미자는 무작정 옥자를 구하기 위해 위험천만한 여정에 나선다."
                    , "틸다 스윈튼, 폴 다노, 안서현, 변희봉, 스티븐 연");
            em.persist(movie10);

            Movie movie11 = creatMovie("헝거게임: 캣칭 파이어", "2013.11.21", "프란시스 로렌스", 146,
                    "판타지, 액션", 8.33, "https://movie-phinf.pstatic.net/20131105_185/1383644515842maJk5_JPEG/movie_image.jpg",
                    "헝거게임의 우승으로 독재국가 ‘판엠’의 절대권력을 위협하는 존재가 된 캣니스, 혁명의 불꽃이 된 그녀를 제거하기 위해 캐피톨은 75회 스페셜 헝거게임의 재출전을 강요한다. 모두의 운명을 걸고 살아남아야 하는 캣니스, 그녀와 함께 혁명의 불꽃이 시작된다."
                    , "제니퍼 로렌스, 조쉬 허처슨, 리암 헴스워스, 우디 해럴슨, 샘 클라플린");
            em.persist(movie11);

            Movie movie12 =creatMovie("전우치", "2009.12.23", "최동훈", 136,
                    "액션, 코미디, 모험", 8.20, "https://movie-phinf.pstatic.net/20111223_249/1324598282916rToPJ_JPEG/movie_image.jpg",
                    "500년 전 조선시대. 전설의 피리 '만파식적'이 요괴 손에 넘어가 세상이 시끄럽자, 신선들은 당대 최고의 도인 천관대사(백윤식)와 화담(김윤석)에게 도움을 요청해 요괴를 봉인하고, 어느덧 전설이 된 2009년 서울. 어찌된 일인지 과거 봉인된 요괴들이 하나 둘 다시 나타나 세상을 어지럽힌다."
                    , "강동원, 김윤석, 임수정, 유해진, 송영창");
            em.persist(movie12);

            Movie movie13 = creatMovie("극한직업", "2019.01.23", "이병헌", 111,
                    "코미디", 9.20, "https://movie-phinf.pstatic.net/20190116_206/1547615429111dINWj_JPEG/movie_image.jpg",
                    "낮에는 치킨장사! 밤에는 잠복근무! 지금까지 이런 수사는 없었다! 불철주야 달리고 구르지만 실적은 바닥, 급기야 해체 위기를 맞는 마약반! 수사는 뒷전, 치킨장사로 눈코 뜰 새 없이 바빠진 마약반에게 어느 날 절호의 기회가 찾아오는데… 범인을 잡을 것인가, 닭을 잡을 것인가!"
                    , "류승룡, 이하늬, 진선규, 이동휘, 공명");
            em.persist(movie13);

            Movie movie14 = creatMovie("드래곤 길들이기", "2010.05.20", "딘 데블로이스, 크리스 샌더스", 181,
                    "SF", 9.49, "https://movie-phinf.pstatic.net/20190417_250/1555465284425i6WQE_JPEG/movie_image.jpg",
                    "인피니티 워 이후 절반만 살아남은 지구 마지막 희망이 된 어벤져스 먼저 떠난 그들을 위해 모든 것을 걸었다! 위대한 어벤져스 운명을 바꿀 최후의 전쟁이 펼쳐진다!"
                    , "로버트 다우니 주니어, 크리스 에반스,크리스 헴스워스, 스칼렛 요한슨, 마크 러팔로 ");
            em.persist(movie14);

            Movie movie15 = creatMovie("어벤져스 - 엔드게임", "2019.04.24", "안소니 루소, 조 루소", 98,
                    "애니메이션, 모험, 코미디, 가족, 판타지", 9.32, "https://movie-phinf.pstatic.net/20190102_130/1546395842249fT9Ei_JPEG/movie_image.jpg",
                    "바이킹 족장의 아들 ‘히컵’은 드래곤 사냥에 소질 없는 마을의 사고뭉치. 어느 날 그는 부상 당한 드래곤, ‘투슬리스’를 구하게 되고, 아무도 몰래 그를 돌본다. 서로를 알아가며, 드래곤들의 친구가 된 ‘히컵’. 그들과의 새로운 생활을 만끽하던 ‘히컵’은 드래곤들의 위험한 비밀을 알게 되는데…"
                    , "제이 바루첼, 제라드 버틀러, 아메리카 페레라, 조나 힐");
            em.persist(movie15);

        }

        private Movie creatMovie(String name, String date, String director, int runningtime, String genre, double rate
                , String poster, String summery,String actors) {
            Movie movie = new Movie();
            movie.setTitle(name);
            movie.setOpenDate(date);
            movie.setDirector(director);
            movie.setRunning_time(runningtime);
            movie.setGenre(genre);
            movie.setRate(rate);
            movie.setPoster(poster);
            movie.setSummary(summery);
            movie.setActors(actors);
            return movie;
        }
    }
}