package socialmedia;

record Post(String content) {

  @Override
  public String toString() {
    return content;
  }

}
