const leftButton = document.querySelector('.left-button');
const rightButton = document.querySelector('.right-button');
const pictures = document.querySelector('.picture-background');
const slider = document.querySelector('.slider');


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
    if (picturesObject['active'] === Object.keys(picturesObject).length -1) {
        picturesObject['active'] = 1;
    }

    pictures.style.background = (`url(/${picturesObject[picturesObject.active]}) no-repeat center center/cover`)
}


function picturesMouseOverListener() {
    pictures.setAttribute('data-width','widened');
    pictures.style.width = "1000px";
}

function sliderOutListener() {
    pictures.setAttribute('data-width','normal');
    pictures.style.width = "650px";
}


pictures.addEventListener("mouseover", picturesMouseOverListener);


slider.addEventListener("mouseout", sliderOutListener);


leftButton.addEventListener("click", leftClickListener);


rightButton.addEventListener("click", rightClickListener);
