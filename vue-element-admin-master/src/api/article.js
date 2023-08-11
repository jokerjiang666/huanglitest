import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/user/selectAll',
    method: 'get',
    params: query
  })
}

export function fetchArticle(id) {
  return request({
    url: '/vue-element-admin/article/detail',
    method: 'get',
    params: { id }
  })
}

export function fetchPv(pv) {
  return request({
    url: '/vue-element-admin/article/pv',
    method: 'get',
    params: { pv }
  })
}

export function createArticle(data) {
  return request({
    url: '/user/updateUser',
    method: 'post',
    data
  })
}

export function updateArticle(data) {
  return request({
    url: '/user/updateUser',
    method: 'post',
    data
  })
}

export function deleteArticle(data) {
  return request({
    url: '/user/delete',
    method: 'delete',
    params: data
  })
}

export function exportUserData(data) {
  return request({
    url: '/user/exportUserData',
    method: 'get',
    params: data,
    responseType: 'blob'
  })
}
