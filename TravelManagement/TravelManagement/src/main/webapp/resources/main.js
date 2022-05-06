/*!
* Start Bootstrap - Agency v7.0.11 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/
//
// Scripts
//

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    const navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // // Activate Bootstrap scrollspy on the main nav element
    // const mainNav = document.body.querySelector('#mainNav');
    // if (mainNav) {
    //     new bootstrap.ScrollSpy(document.body, {
    //         target: '#mainNav', offset: 74,
    //     });
    // }
    // ;

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(document.querySelectorAll('#navbarResponsive .nav-link'));
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

function addFeedback(tourId, userId) {
    fetch("/TravelManagement/api/add-feedback", {
        method: 'post', body: JSON.stringify({
            "rating": $("input[name='rating']:checked").val(),
            "comment": document.getElementById("comment").value,
            "tourId": tourId,
            "userId": userId
        }), headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    }).then(function (res) {
        console.info(res);
        return res.json();

    }).then(function (data) {
        console.info(data);

        let area = document.getElementById("feedbackSection");
        area.innerHTML = `
            <div class="media border my-2 p-3">
                <img src="https://dulichviet.com.vn/images/bandidau/Du-lich-Chau-a/Thai-Lan/du-lich-thai-lan-tham-quan-chua-nui-vang-gia-tot-du-lich-viet.jpg"
                     alt="${data.user.username}" class="mr-3 mt-3 rounded-circle" style="width:60px;height: 60px;
                      background-size: cover">
                <div class="media-body">
                    <h6>
                        <c:choose>
                            <c:when test="${data.user.firstName != null && data.user.lastName != null}">
                                ${data.user.lastName} ${data.user.firstName}
                            </c:when>
                            <c:otherwise>Ẩn danh</c:otherwise>
                        </c:choose>
                        <small><i class="feedback-createDate">${moment(data.createdDate).fromNow()}</i></small>
                    </h6>
                    <p>
                        <c:choose>
                            <c:when test="${data.rating > 0}"><small>
                                <c:forEach begin="1" end="5" varStatus="loop">
                                    ${(loop.index > data.rating) ? '<i class="fa-regular fa-star"></i>' : '<i class="fa-solid fa-star"></i>'}
                                </c:forEach>
                            </small></c:when>
                        </c:choose>
                    </p>
                    <p>${data.comment}</p>
                </div>
            </div>
        ` + area.innerHTML
    })
}

moment.updateLocale('vi', {
    relativeTime: {
        future: "trong %s",
        past: "%s trước",
        s: 'vài giây',
        ss: '%d giây',
        m: "một phút",
        mm: "%d phút",
        h: "một giờ",
        hh: "%d giờ",
        d: "một ngày",
        dd: "%d ngày",
        w: "một tuần",
        ww: "%d tuần",
        M: "một tháng",
        MM: "%d tháng",
        y: "một năm",
        yy: "%d năm"
    }
});
moment.locale('vi');


