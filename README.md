# SwipeRefreshLayout
## 프로젝트 설명
view binding을 추가하여 findViewById()가 등장하지 않습니다.
스와이프 제스처로 새로고침을 원할 때 사용하는 SwipeRefreshLayout을 사용하는 방법을 공부하기 위해 만든 프로젝트입니다. 주석이 포함되어 있습니다.

## 라이브러리 추가
모듈 build.gradle 파일에 SwipeRefreshLayout 라이브러리를 아래와 같이 추가합니다.
<pre>
dependencies {
    ...
    // Swipe Refresh Layout
    implementation'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
}
</pre>

## 코드
<pre>
binding.srl.setOnRefreshListener(() -> { // 새로고침 이벤트 발생 시 실행되는 콜백 메서드입니다.
    Log.i(TAG, "onCreate: swipe refresh layout에서 refresh 이벤트 발생");
    binding.srl.setRefreshing(false); // 새로고침 시 필요한 작업이 완료되었을 때 새로고침의 시각적 표시를 종료하는 메서드.
//    binding.srl.setRefreshing(true); // 새로고침의 시각적 표시가 지속적으로 표시되기를 원할 때 true로 설정
});
</pre>

## 참고 사항
이 레이아웃은 vertical swipe 이벤트 발생 시 새로고침할 뷰의 부모 뷰로 만들어야 합니다.
그리고 하나의 direct 자식만 지원합니다.
또한 이 레이아웃의 자식에게 width와 height에게 match_parent값이 제공됩니다.

## 공식 문서
### 새로고침 관련 문서
https://developer.android.com/training/swipe/add-swipe-interface?hl=ko
### SwipeRefreshLayout문서
https://developer.android.com/reference/androidx/swiperefreshlayout/widget/SwipeRefreshLayout
