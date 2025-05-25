# -*- coding: utf-8 -*-
# @Author  : YongbinMiao
# @Time    : 2023-05-18 09:27:07
import streamlit as st
import openai
import os
from openai.embeddings_utils import cosine_similarity, get_embedding

openai.api_base = "https://openai.com/v1"
openai.api_key = 'sk-Pome60pM03s3cT763aF16648B1414eA4B9Aa55DdF6531d89'
# 选择使用最小的ada模型
EMBEDDING_MODEL = "text-embedding-ada-002"
# 获取"好评"和"差评"的
positive_review = get_embedding("好评")
negative_review = get_embedding("差评")


def get_score(sample_embedding):
    return cosine_similarity(sample_embedding, positive_review) - cosine_similarity(sample_embedding, negative_review)


def main():
    st.title("NLP")
    st.subheader("欢迎使用NLP机器人！！！")
    text = st.text_area("请输入文本")
    st.write("""你输入的是:  \n""", text)
    if st.button("分析"):
        text1 = get_embedding(text)
        result = get_score(text1)
        if result > 0.0:
            custom_emoji = ':blush:'
            st.success('Happy : {}'.format(custom_emoji))
            st.success('原始评论 : {}'.format(text))
            st.balloons()
        elif result < 0.0:
            custom_emoji = ':disappointed:'
            st.warning('Sad : {}'.format(custom_emoji))
            st.warning('原始评论 : {}'.format(text))
            st.snow()
        else:
            custom_emoji = ':confused:'
            st.info('Confused : {}'.format(custom_emoji))
        st.success("得分是: {}".format(result))
    st.title("例子:")
    st.code("""买的银色版真的很好看，一天就到了，晚上就开始拿起来完系统很丝滑流畅，做工扎实，手感细腻，很精致哦苹果一如既往的好品质""")
    st.code("""降价厉害，保价不合理，不推荐""")


if __name__ == '__main__':
    main()
