const leftButton = document.querySelector('.left-button');
const rightButton = document.querySelector('.right-button');
const picturesBackground = document.querySelector('.picture-background');
const pictures = document.querySelector('.pictures');
const slider = document.querySelector('.slider');

const navBurger = document.querySelector('.fas.fa-bars');
const navBarOpened = document.querySelector('#navbar-opened');


const picturesObject = {};

picturesObject[1] = 'static/img/gallery/cupid_chastised.png';
picturesObject[2] = 'static/img/gallery/hercules_and_the_hydra.png';
picturesObject[3] = 'static/img/gallery/love_of_winter.png';
picturesObject[4] = 'static/img/gallery/mona_lisa.png';
picturesObject[5] = 'static/img/gallery/Portrait_of_Marevna.png';
picturesObject[6] = 'static/img/gallery/ready_to_eear.png';
picturesObject[7] = 'static/img/gallery/the_artis_looks_at_nature.png';
picturesObject[8] = 'static/img/gallery/the_bedroom.png';
picturesObject[9] = 'static/img/gallery/the_red_armchair.png';
picturesObject[10] = 'static/img/gallery/untitled.png';
picturesObject[11] = 'static/img/gallery/women_of_algiers.png';
picturesObject['active'] =  7;


function leftClickListener() {
    picturesObject['active']--;
    if (picturesObject['active'] === 0) {
        picturesObject['active'] = Object.keys(picturesObject).length -1;
    }

    pictures.style.background = (`url(/${picturesObject[picturesObject.active]}) no-repeat center center/cover`)
}

function rightClickListener() {
    picturesObject['active']++;
    if (picturesObject['active'] === Object.keys(picturesObject).length) {
        picturesObject['active'] = 1;
    }

    pictures.style.background = (`url(/${picturesObject[picturesObject.active]}) no-repeat center center/cover`)
}


function picturesMouseOverListener() {
    picturesBackground.setAttribute('data-width','widened');
    picturesBackground.style.width = "1000px";
}

function sliderOutListener() {
    picturesBackground.setAttribute('data-width','normal');
    picturesBackground.style.width = "650px";
}


function navBurgerOpen() {
    if (navBarOpened.getAttribute("data-visibility") === "false") {
        let height = 0;
        let id = setInterval(slideDown, 1);
        function slideDown() {
            navBarOpened.style.display = "block";
            navBarOpened.setAttribute("data-visibility", "true");
            if (height >= 500) {
                clearInterval(id);
            } else {
                height += 3;
                navBarOpened.style.height = height + 'px';
            }
        }
    }
}

function navBurgerClose() {
    if (navBarOpened.getAttribute("data-visibility") === "true") {
        let height = 500;
        let id = setInterval(slideUp, 1);
        function slideUp() {
            navBarOpened.setAttribute("data-visibility", "false");
            if (height <= 0) {
                navBarOpened.style.display = "none";
                clearInterval(id);
            } else {
                height -= 3;
                navBarOpened.style.height = height + 'px';
            }
        }
    }
}


picturesBackground.addEventListener("mouseover", picturesMouseOverListener);


slider.addEventListener("mouseleave", sliderOutListener);


leftButton.addEventListener("click", leftClickListener);


rightButton.addEventListener("click", rightClickListener);



navBurger.addEventListener("click", navBurgerOpen);
navBurger.addEventListener("click", navBurgerClose);
