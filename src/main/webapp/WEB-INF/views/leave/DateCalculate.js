$(document).ready(function() {
    console.log("시작 했나요?");
    // leaveType의 값이 변경될 때마다 leaveDays 값을 조절합니다.
    // 휴가 유형이 변경될 때마다 총 휴가일수를 계산합니다.
    $('#leaveType').change(function() {
        calculateLeaveDays(); // 휴가 유형이 변경될 때마다 총 휴가일수를 계산합니다.
    });

    // 휴가 시작일과 종료일이 변경될 때마다 총 휴가일수를 계산합니다.
    $('#startDate, #endDate').change(function() {
        calculateLeaveDays();
    });

    function calculateLeaveDays() {
        var startDateValue = $('#startDate').val(); // input 요소의 값을 가져옴
        var startDate = new Date(startDateValue); // 값에서 Date 객체 생성
        var endDateValue = $('#endDate').val(); // input 요소의 값을 가져옴
        var endDate = new Date(endDateValue); // 값에서 Date 객체 생성

        var leaveType = $('#leaveType').val(); // 휴가 유형
        var leaveDays = 0; // 총 휴가일수
        console.log(startDate);
        console.log(endDate);
        console.log(leaveType);
        console.log(leaveDays);

        console.log("11");
        if (startDate && endDate) {
            // 종료일에서 시작일을 뺀 후 하루를 더해서 기간을 구합니다.
            var timeDiff = endDate.getTime() - startDate.getTime();
            var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)) + 1;
            console.log("22");
            // 시작일과 종료일이 같은 경우
            if (startDate.getTime() === endDate.getTime()) {
                console.log("33");
                // 휴가 유형에 따라 총 휴가일수를 결정합니다.
                if (leaveType === '연차' || leaveType === '병가' || leaveType === '가족돌봄휴가' || leaveType === '출산휴가') {
                    leaveDays = 1;
                } else if (leaveType === '반차') {
                    leaveDays = 0.5;
                } else if (leaveType === '반반차') {
                    leaveDays = 0.25;
                }
            } else { // 시작일과 종료일이 다른 경우
                console.log("44");
                // 반차나 반반차를 선택했을 때 경고 메시지를 표시하고 다른 값을 선택하도록 합니다.
                if (leaveType === '반차' || leaveType === '반반차') {
                    console.log("55");
                    alert('시작일과 종료일이 다를 때 반차나 반반차는 선택할 수 없습니다.\n다른 값을 선택해주세요.');
                    $('#leaveType').val('연차'); // 휴가 유형을 연차로 변경합니다.
                    return; // 함수 종료
                } else {
                    // 그 외의 경우에는 실제 기간에 맞춰 총 휴가일수를 계산합니다.
                    leaveDays = diffDays;
                }
                console.log("66");
            }
        }

        // 총 휴가일수를 출력합니다.
        $('#leaveDays').val(leaveDays);
    }


});
