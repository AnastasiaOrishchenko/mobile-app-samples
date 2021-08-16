import React from 'react';
import {formatPhotoUri} from '../api/picsum';
import {Image, TouchableOpacity} from 'react-native';

function PhotoGridItem({photo, size, onClick}) {
  return (
    <TouchableOpacity onPress={onClick}>
      <Image
        source={{
          width: size,
          height: size,
          uri: formatPhotoUri(photo.id, size, size),
        }}
      />
    </TouchableOpacity>
  );
}

export default PhotoGridItem;
