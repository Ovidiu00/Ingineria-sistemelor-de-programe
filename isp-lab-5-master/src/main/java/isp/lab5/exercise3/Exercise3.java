package isp.lab5.exercise3;

public class Exercise3 {

    interface Playable {
        void play();
    }

    class ColorVideo implements Playable {

        private String fileName;

        public ColorVideo(String fileName){
            this.fileName = fileName;
            loadFromDisk(fileName);
        }

        @Override
        public void play() {
            System.out.println("Play " + fileName);
        }

        private void loadFromDisk(String fileName){
            System.out.println("Loading video..." + fileName);
        }
    }

    class ProxyVideo implements Playable {

        private Playable video;
        private String fileName;

        public ProxyVideo(String fileName, boolean isColored){
            this.fileName = fileName;

            if(isColored){
                video = new ColorVideo("Colored video");
            }
            else{
                video = new BlackAndWhiteVideo("Black and white video");
            }
        }

        @Override
        public void play() {
            if(video == null){
                video = new ColorVideo(fileName);
            }
            video.play();
        }
    }
    class BlackAndWhiteVideo implements  Playable{

        private String fileName;

        public BlackAndWhiteVideo(String fileName){
            this.fileName = fileName;

        }

        @Override
        public void play() {
            System.out.println("Play black and white video  " + fileName);
        }


    }
}
